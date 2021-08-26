package com.ambow.controller;

import com.ambow.bean.BigInfo;
import com.ambow.bean.PageInfo;
import com.ambow.bean.SmallInfo;
import com.ambow.bean.UserInfo;
import com.ambow.service.BigService;
import com.ambow.service.SmallService;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class BigController {
    @Autowired
    private BigService bigService;
    @Autowired
    private SmallService smallService;
    @RequestMapping("/allBig")
    public String allBig(Model model, HttpSession session){
       /* Integer h=1;
        if(h.equals(1)){
            System.out.println("");
        }*/





        List<BigInfo> list=bigService.selectAll();

        UserInfo user=(UserInfo) session.getAttribute("userses");
        System.out.println("大类返回用户"+user.getUname());
        model.addAttribute("user",user);
        model.addAttribute("allBig",list);
        return "redirect:/bigListPage";
    }
    @RequestMapping("/importBig")
    private void importBig(HttpServletRequest request, HttpServletResponse response) {
        // TODO Auto-generated method stub
        String path=request.getParameter("filename");
        path = "C:\\Users\\asus\\Desktop\\"+path;
        System.out.println(path);
        try {

            FileInputStream fis=new FileInputStream(path);
            HSSFWorkbook wb=new HSSFWorkbook(fis);
            List<BigInfo> list=new ArrayList<BigInfo>();
            for(int i=0;i<wb.getNumberOfSheets();i++){
                HSSFSheet s=wb.getSheetAt(i);
                if(s==null){
                    System.out.println("值为空");
                    continue;
                }
                for(int j=1;j<=s.getLastRowNum();j++){
                    System.out.println("进入传值");
                    HSSFRow r=s.getRow(j-1);
                    BigInfo big=new BigInfo();
                    if(r!=null){


                        HSSFCell c0=r.getCell(0);
                        c0.setCellType(Cell.CELL_TYPE_STRING);
                        String value1=c0.getStringCellValue();
                        // System.out.println(j+"行第一列的值是"+value);

                        big.setBid(Integer.parseInt(value1));

                        HSSFCell c1=r.getCell(1);
                        c1.setCellType(Cell.CELL_TYPE_STRING);
                        String value2=c1.getStringCellValue();
                        System.out.println(value2);
                        big.setBname(value2);

                        HSSFCell c2=r.getCell(2);
                        c2.setCellType(Cell.CELL_TYPE_STRING);
                        String value3=c2.getStringCellValue();
                        big.setBtype(value3);
                        list.add(big);
                    }
                }
                for(BigInfo big:list){
                    System.out.println(big.getBtype()+"类型");
                    System.out.println(big.getBname()+"名字");
                    bigService.addBig(big);
                }
            }
        } catch (NumberFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @RequestMapping("/allBi")
    public String allBi(Model model, HttpSession session){
        List<BigInfo> list=bigService.selectAll();
        model.addAttribute("allBig",list);
        return "addSmall";
    }
    @RequestMapping("/addBig")
    public String addBig(BigInfo bigInfo){
        BigInfo bigInfo1=bigService.selectNameAndType(bigInfo);
        if(bigInfo1!=null){
            System.out.println("未添加");
            return "redirect:/allBig";
        }else{
            bigService.addBig(bigInfo);
            return "redirect:/allBig";
        }

    }
    @RequestMapping("/delBig")
    public String delBig(int id,Model model,String aa){
        System.out.println("删除大类");
        List<SmallInfo> list=smallService.getSmallInfo(id);
        System.out.println(list.size());
        if(list.size()!=0){
            System.out.println("删除失败");
            return "redirect:/allBig";
        }else{

            System.out.println("删除成功");
            bigService.delBig(id);
            return "redirect:/allBig";
        }

    }
    @RequestMapping("/byIdBig")
    public String byIdBig(BigInfo bigInfo,Model model){
        System.out.println("查用户");
        BigInfo big=bigService.byIdBig(bigInfo);
        System.out.println("根据id查用户"+big.getBname());
        model.addAttribute("bigById",big);
        return "updateBig";
    }
    @RequestMapping("/updateBig")
    public String update(BigInfo bigInfo){
        BigInfo bigInfo1=bigService.selectNameAndType(bigInfo);
        if(bigInfo1!=null){
            return "redirect:/allBig";
        }else{
            bigService.updateBig(bigInfo);
            System.out.println("修改"+bigInfo.getBname());
            return "redirect:/allBig";
        }

    }
    @RequestMapping("/bigListPage")
    public String bigListPage(Model model, HttpServletRequest request,HttpSession session){
        String page=request.getParameter("page");
        System.out.println("分页");
        int yetiao = 3 ;
        if(page==null){
            page =1+"";
        }
        List<BigInfo> list=bigService.allBigServicePage((Integer.parseInt(page)-1)*yetiao,yetiao);
        System.out.println("service没问题");
        UserInfo user=(UserInfo) session.getAttribute("userses");
        System.out.println("大类返回用户"+user.getUname());
        model.addAttribute("user",user);
        model.addAttribute("listBig", list);
        model.addAttribute("page", page);
        PageInfo pageInfo=new PageInfo();
        pageInfo.setDangPage(Integer.parseInt(page));
        pageInfo.setYeTiao(yetiao);
        List<BigInfo> list1=bigService.selectAll();
        int allNum=list1.size();
        System.out.println("list1..."+list1.size());
        pageInfo.setTotalTiao(allNum);//总条数，数据库一共多少条
        model.addAttribute("lastPage", pageInfo.getTotalPage());
        return "bigList";
    }
}
