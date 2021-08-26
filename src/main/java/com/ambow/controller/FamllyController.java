package com.ambow.controller;

import com.ambow.bean.FamllyInfo;
import com.ambow.bean.UserInfo;
import com.ambow.service.FamllyService;
import com.ambow.service.UserService;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class FamllyController {
    @Autowired
    private FamllyService famllyService;
    @Autowired
    private UserService userService;
    @RequestMapping("/addFamlly")
    public String addFamlly(FamllyInfo famllyInfo, Model model) {
        System.out.println("添加家庭");
        famllyService.addFamlly(famllyInfo);
        return "index";
    }
    @RequestMapping("/forgetfpwd")
    public String forget(FamllyInfo famllyInfo){
        System.out.println("忘记密码");
        famllyService.forget(famllyInfo);
        System.out.println("修改"+famllyInfo.getFname());
        return "index";
    }
   // @ResponseBody
    @RequestMapping("/delFamlly")
    public String delFamlly(FamllyInfo famllyInfo,HttpSession session){
        System.out.println("进入删除");
        UserInfo userInfo=(UserInfo) session.getAttribute("userses");
        List<UserInfo> list=userService.byName(userInfo);
        System.out.println("list集合"+list.size());
        if(list.size()==0){
            System.out.println("删除方法");
            int a=famllyInfo.getFid();
            famllyService.delFamlly(a);
            return "redirect:/allFamlly?id="+2;
        }else{
            System.out.println("有人未删除");
            return "redirect:/ByName";
        }

    }
    @RequestMapping("/byIdFamlly")
    public String byIdFamlly(FamllyInfo famllyInfo,Model model){
        FamllyInfo famlly=famllyService.byIdFamlly(famllyInfo);
        System.out.println("根据id查用户"+famlly.getFname());
        model.addAttribute("famllyById",famlly);
        return "updateFamlly";
    }
    @RequestMapping("/updateFamlly")
    public String updateFamlly(FamllyInfo famllyInfo){
        System.out.println("id"+famllyInfo.getFid());
        System.out.println("密码"+famllyInfo.getFpwd());
        famllyService.updateFamlly(famllyInfo);
        System.out.println("修改"+famllyInfo.getFname());
        //return "redirect:/allUser?a="+a;
        return "redirect:/allFamlly?id="+2;
    }
    @RequestMapping("/allFamlly")
    public String allUser(Model model, int id, HttpSession session){
        System.out.println("所有家庭");
        List<FamllyInfo> list=famllyService.selectAll();
        List<UserInfo> list1=userService.byFlag();
        UserInfo userInfo=(UserInfo)session.getAttribute("userses");
        System.out.println("身份SSSSS");
        model.addAttribute("allFamlly",list);
        model.addAttribute("allFamlly1",list1);
        model.addAttribute("user",userInfo);
        if(id==1){
            return "adUser";
        }else if(id==2) {
            return "famllyList";
        }
        return null;
    }
    @RequestMapping("/importFamlly")
    private void importUser(HttpServletRequest request, HttpServletResponse response) {
        // TODO Auto-generated method stub
        String path=request.getParameter("filename");
        path = "C:\\Users\\asus\\Desktop\\"+path;
        System.out.println(path);
        try {

            FileInputStream fis=new FileInputStream(path);
            HSSFWorkbook wb=new HSSFWorkbook(fis);
            List<FamllyInfo> list=new ArrayList<FamllyInfo>();
            for(int i=0;i<wb.getNumberOfSheets();i++){
                HSSFSheet s=wb.getSheetAt(i);
                if(s==null){
                    System.out.println("值为空");
                    continue;
                }
                for(int j=1;j<=s.getLastRowNum();j++){
                    System.out.println("进入传值");
                    HSSFRow r=s.getRow(j-1);
                    FamllyInfo famlly=new FamllyInfo();
                    if(r!=null){


                        HSSFCell c0=r.getCell(0);
                        c0.setCellType(Cell.CELL_TYPE_STRING);
                        String value1=c0.getStringCellValue();
                        // System.out.println(j+"行第一列的值是"+value);

                        famlly.setFid(Integer.parseInt(value1));

                        HSSFCell c1=r.getCell(1);
                        c1.setCellType(Cell.CELL_TYPE_STRING);
                        String value2=c1.getStringCellValue();
                        System.out.println(value2);
                        famlly.setFname(value2);

                        HSSFCell c2=r.getCell(2);
                        c2.setCellType(Cell.CELL_TYPE_STRING);
                        String value3=c2.getStringCellValue();
                        famlly.setFpwd(value3);
                        list.add(famlly);
                    }
                }
                for(FamllyInfo famllyInfo:list){
                    famllyService.addFamlly(famllyInfo);
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

   /* @RequestMapping("/addFamlly")
    public String addUser(@RequestParam("filename") MultipartFile file, HttpServletRequest request, Model model, UserInfo userInfo) throws IOException {
        System.out.println("tian加用户");
        List<UserInfo> list =userService.selectAll();
        int a = list.size()==0?1:0;
        userInfo.setUflag(a);
        String path=request.getServletContext().getRealPath("/img");
        String fileName=file.getOriginalFilename();
        userInfo.setUimg(fileName);
        File filename=new File(path,fileName);
        if(!filename.getParentFile().exists()){
            filename.getParentFile().mkdirs();
        }
        file.transferTo(filename);
        System.out.println("完成");
        userService.addUser(userInfo);
        return "home";
    }
    @RequestMapping("/addUse")
    public String addUse(@RequestParam("filename") MultipartFile file, HttpServletRequest request,Model model, UserInfo userInfo) throws IOException {
        System.out.println("tian加用户");
        List<UserInfo> list =userService.selectAll();
        int a = list.size()==0?1:0;
        userInfo.setUflag(a);
        String path=request.getServletContext().getRealPath("/img");
        String fileName=file.getOriginalFilename();
        userInfo.setUimg(fileName);
        File filename=new File(path,fileName);
        if(!filename.getParentFile().exists()){
            filename.getParentFile().mkdirs();
        }
        file.transferTo(filename);
        System.out.println("完成");
        userService.addUser(userInfo);
        return "index";
    }*/

}
