package com.ambow.controller;

import com.ambow.bean.*;
import com.ambow.service.BigService;
import com.ambow.service.RecordService;
import com.ambow.service.SmallService;
import com.ambow.service.UserService;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class RecordController {
@Autowired
    private RecordService recordService;
@Autowired
    private SmallService smallService;
@Autowired
    private BigService bigService;
@Autowired
    private UserService userService;
    @RequestMapping("/zzt")
    public String zzt(Model model,HttpServletRequest request,HttpSession session){
        String a=request.getParameter("time");
        String b=request.getParameter("tim");
        if(a==null&&b==null){
            return "redirect:/recordListPage";
        }else if(a==null||b==null ){
            return "redirect:/recordListPage";
        }
        UserInfo userInfo=(UserInfo) session.getAttribute("userses");
        int c=userInfo.getUid();

        List<RecordInfo> shourulist=recordService.byTime(c,a,b,1);// 该用户该时间段的所有记录   // 一个该用户这个时间段的收入     支出
        System.out.println("shouru"+shourulist.size());
        List<RecordInfo> zhichulist=recordService.byTime(c,a,b,0);
        System.out.println("zhichu="+zhichulist.size());
        Double shouru [] = new Double[shourulist.size()];
        Double zhichu[] = new Double[zhichulist.size()];

        double ab=0;
        double abb=0;

        for(int i = 0 ; i < shourulist.size() ; i ++){
            shouru[i]= shourulist.get(i).getMoney();
            ab=ab+shourulist.get(i).getMoney();
            System.out.println("ab="+ab);
        }

        for(int i = 0 ; i < zhichulist.size() ; i ++){
            zhichu[i]= zhichulist.get(i).getMoney();
            abb=abb+zhichulist.get(i).getMoney();
            System.out.println("abb"+abb);
        }

        int length  = 0 ;
        if(shouru.length > zhichu.length){
           length = shouru.length;
        }else{
            length = zhichu.length;
        }

        String tian[] = new String[length];
        for(int i = 0 ;i <tian.length ; i ++){
            tian[i]=(i+1)+"天";
        }
        model.addAttribute("ab",ab);
        model.addAttribute("abb",abb);
        model.addAttribute("tian1",tian);
        model.addAttribute("tianlength",length);
        model.addAttribute("shouru",shouru);
        model.addAttribute("shouruleng",shourulist.size());
        model.addAttribute("zhichu",zhichu);
        model.addAttribute("zhichuleng",zhichulist.size());

        return "zzt";
    }
/*@RequestMapping("/zzt")
public String zzt(Model model,HttpServletRequest request,HttpSession session){
    String a=request.getParameter("time");
    String b=request.getParameter("tim");
    if(a==null&&b==null){
        return "redirect:/recordListPage";
    }else if(a==null||b==null ){
        return "redirect:/recordListPage";
    }
    UserInfo userInfo=(UserInfo) session.getAttribute("userses");
    System.out.println("fangfazhong猜测是");
    int c=userInfo.getUid();
    List<RecordInfo> list=recordService.byTime(c,a,b);
    ArrayList<Double> ArrayList=new ArrayList<Double>();
    ArrayList<Double> List=new ArrayList<Double>();
    System.out.println("zzt长度"+list.size());
    double ab=0;
    double abb=0;
    for(RecordInfo items:list){
        String m=items.getRsid().getBsid().getBtype();
        System.out.println(m+"mmmmmmmmm");
        if(m.equals("1")){
            double aaa=items.getMoney();
            System.out.println("遍历");
            System.out.println("double"+aaa);
            ab=ab+items.getMoney();
            ArrayList.add(aaa);
        }else if(m.equals("0")){
            double bbb=items.getMoney();
            abb=abb+items.getMoney();
            System.out.println("BBB"+bbb);
            List.add(bbb);
        }



    }
    System.out.println(ab+"ab");
    System.out.println(abb+"abb");
    System.out.println(""+ArrayList);
    System.out.println("柱状");
    model.addAttribute("siz",ArrayList.size());
    model.addAttribute("sz",List.size());
    model.addAttribute("ab",ab);
    model.addAttribute("abb",abb);
    model.addAttribute("time",ArrayList);
    model.addAttribute("tim",List);
    return "zzt";
}*/
@RequestMapping("/byUnumRecord")
public String byUnumRecord(Model model, HttpSession session){
    UserInfo userInfo=(UserInfo) session.getAttribute("userses");
    System.out.println("UUUUUUUUUUUU");
    System.out.println("session中"+userInfo.getUnum().getFid());
    List<RecordInfo> list=recordService.byUnumRecord(userInfo);
    model.addAttribute("allSmall",list);
    return "redirect:/smallListPage";
}
@RequestMapping("/allRecord")
    public String allRecord(Model model, HttpSession session){
        List<RecordInfo> list=recordService.selectAll();
        model.addAttribute("allSmall",list);
        return "redirect:/smallListPage";
    }

    @RequestMapping("/recorddy")
    @ResponseBody
    public List<SmallInfo> recorddy(int value){
        //String str =request.getParameter("value");//是大类id
       // response.setContentType("application/json;charset=utf-8");
        List<SmallInfo> list=smallService.getSmallInfo(value);
       /* Map<String,Object> map=new HashMap<String,Object>();
        map.put("allSmall", true);
        map.put("ceshi", "恭喜你第一次异步成功");*/
       return list ;

    }
    @RequestMapping("/exportRecord")
    public String exportRecord(Model model,HttpServletResponse response){
        List<RecordInfo> list=recordService.selectAll();
        try {
            HSSFWorkbook wb=new HSSFWorkbook();
            HSSFSheet s=wb.createSheet("用户信息");
            HSSFRow r1=s.createRow(0);
            String str[]={"id","name","flag","pwd","img"};
            for(int i=0;i<str.length;i++){
                HSSFCell cell=r1.createCell(i);
                cell.setCellValue(str[i]);
            }
            for(int i=1;i<=list.size();i++){
                HSSFRow r=s.createRow(i);
                RecordInfo record=list.get(i-1);
                HSSFCell cell=r.createCell(0);
                cell.setCellValue(record.getRid());

                HSSFCell cell1=r.createCell(1);
                cell1.setCellValue(record.getRuname());
                HSSFCell cell2=r.createCell(2);
                cell2.setCellValue(record.getRsid().getSname());
                HSSFCell cell3=r.createCell(3);
                cell3.setCellValue(record.getRtime());
                HSSFCell cell4=r.createCell(4);
                cell4.setCellValue(record.getMoney());
                HSSFCell cell5=r.createCell(5);
                cell5.setCellValue(record.getRuname());
                HSSFCell cell6=r.createCell(6);
                cell6.setCellValue(record.getUid().getUname());
                HSSFCell cell7=r.createCell(7);
                cell7.setCellValue(record.getWtime());
                HSSFCell cell8=r.createCell(8);
                cell8.setCellValue(record.getBeizhu());

            }
            response.setContentType("application/x-download");
            response.setHeader("Content-Disposition", "attachment;filename=record.xls");
            OutputStream out =response.getOutputStream();
            wb.write(out);
            out.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
    @RequestMapping("/recordAdd")
    public String allBi(Model model, HttpSession session){
        System.out.println("添加HHHHHHHHH记录");
        List<SmallInfo> listSmall=smallService.selectAll();
        UserInfo user=(UserInfo) session.getAttribute("userses");
        System.out.println("session中"+user.getUnum().getFid());
        List<UserInfo> lis=userService.byName(user);
        System.out.println("添加GGGGGGG记录");
        System.out.println(lis.get(0).getUname());
        model.addAttribute("lis",lis);


        System.out.println("tianjia");
        System.out.println("查所有"+listSmall.get(0).getBsid().getBname());
        Map<Integer, BigInfo> map=new HashMap<Integer, BigInfo>();
        for(SmallInfo info:listSmall){
            map.put(info.getBsid().getBid(), info.getBsid());
        }
        model.addAttribute("listBig", map.values());
        return "addRecord";
    }
    @RequestMapping("/addRecord")
    public String addRecord(RecordInfo recordInfo,HttpSession session,HttpServletRequest request){
        System.out.println("记录表"+recordInfo.getRuname());
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String wtime=df.format(new Date());
        recordInfo.setWtime(wtime);
        UserInfo user=(UserInfo) session.getAttribute("userses");
        System.out.println("大类返回用户"+user.getUname());
        SmallInfo sss=new SmallInfo();
        String a = request.getParameter("tt");
        sss.setSid(Integer.parseInt(a));
        recordInfo.setRsid(sss);
        recordInfo.setUid(user);
        recordService.addRecord(recordInfo);
        return "redirect:/recordListPage";
    }
    @RequestMapping("/delRecord")
    public String delRecord(int id,Model model,String aa){
        recordService.delRecord(id);
        return "redirect:/recordListPage";
    }
    @RequestMapping("/byIdRecord")
    public String byIdRecord(RecordInfo recordInfo,Model model,int id){
        System.out.println("查小类对应大类");
        System.out.println("id"+id);
        System.out.println("record");
        List<SmallInfo> re=smallService.getSmallInfo(id);
        System.out.println("re===="+re.size());
        RecordInfo rrr=new RecordInfo();
        rrr.setRid(id);
        RecordInfo record=recordService.byIdRecord(rrr);
        List<SmallInfo> listSmall=smallService.selectAll();
        List<BigInfo> listBig=bigService.selectAll();
        SmallInfo a=new SmallInfo();
        System.out.println("fsfdsfdfssdfsfafa");
        System.out.println("tttt"+record);
        System.out.println("dddd"+record.getRsid().getSid());
        a.setSid(record.getRsid().getSid());
        SmallInfo bu=smallService.byIdSmall(a);
        /*  System.out.println("根据id查dalei"+list.get(0).getBname());
        model.addAttribute("allBig",list);*/
        model.addAttribute("byId",bu);
        model.addAttribute("listSmall",re);
        model.addAttribute("listBig", listBig);
        model.addAttribute("byIdRecord",record);
        return "updateRecord";
    }
    @RequestMapping("/updateRecord")
    public String update(RecordInfo recordInfo,HttpSession session,HttpServletRequest request){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String wtime=df.format(new Date());
        recordInfo.setWtime(wtime);
        UserInfo user=(UserInfo) session.getAttribute("userses");
        System.out.println("大类返回用户"+user.getUname());
        SmallInfo sss=new SmallInfo();
        String a = request.getParameter("tt");
        sss.setSid(Integer.parseInt(a));
        recordInfo.setRsid(sss);
        recordInfo.setUid(user);
        recordService.updateRecord(recordInfo);
        System.out.println("修改"+recordInfo.getRuname());
        return "redirect:/recordListPage";
    }
    @RequestMapping("/recordListPage")
    public String recordListPage(Model model, HttpServletRequest request, HttpSession session){
        String page=request.getParameter("page");
        System.out.println("分页");
        int yetiao = 3 ;
        if(page==null){
            page =1+"";
        }
        UserInfo user=(UserInfo) session.getAttribute("userses");
        System.out.println("记录表用户");
        System.out.println("记录返回用户"+user.getUnum().getFid());

        model.addAttribute("user",user);
        int number=user.getUid();
        if(number==1){
            List<RecordInfo> list=recordService.getAllRecord((Integer.parseInt(page)-1)*yetiao,yetiao);
            model.addAttribute("listRecord", list);
        }else{
            List<RecordInfo> list=recordService.allRecordServicePage(number,(Integer.parseInt(page)-1)*yetiao,yetiao);
            model.addAttribute("listRecord", list);
        }
        /*System.out.println("number"+number);
        System.out.println("service没问题"+list);
        System.out.println("页面数据长度"+list.size());
        for(SmallInfo items:list){
            System.out.println("大类名"+items.getBsid().getBname());
        }*/
        model.addAttribute("page", page);
        PageInfo pageInfo=new PageInfo();
        pageInfo.setDangPage(Integer.parseInt(page));
        pageInfo.setYeTiao(yetiao);
        List<RecordInfo> list1=recordService.selectAll();
        int allNum=list1.size();
        System.out.println("list2..."+list1.size());
        pageInfo.setTotalTiao(allNum);//总条数，数据库一共多少条
        model.addAttribute("lastPage", pageInfo.getTotalPage());
        return "recordList";
    }
}
