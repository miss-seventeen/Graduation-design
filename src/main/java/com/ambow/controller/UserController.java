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
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private FamllyService famllyService;
    @RequestMapping("/login")
    public String userLogin(HttpSession session,UserInfo user, Model model) {
       //System.out.println("dadad");
        //System.out.println(user.getUpwd()+""+user.getUname());
        System.out.println("mingz"+user.getUname());
        UserInfo login=userService.selectByNameAndPwd(user);
        System.out.println("unum"+user.getUnum());

       // System.out.println("login"+login.getUname()+login.getUid());
        if(login!=null) {
            //通过登录成功的用户名和密码查询数据库并且将查询结果放入session
            model.addAttribute("admin",login);
            session.setAttribute("userses",login);
            UserInfo userInfo=(UserInfo) session.getAttribute("userses");
           // model.addAttribute("uuu",userInfo);
            System.out.println("登录者"+userInfo.getUname());
            return "home";
        }else{
            return "index";
        }
    }

    @RequestMapping("/forget")
    public String forget(UserInfo userInfo){
        System.out.println("忘记密码");
        userService.forget(userInfo);
        System.out.println("修改"+userInfo.getUname());
        return "index";
    }

@RequestMapping("/exportUser")
public String exportUser(Model model, HttpServletResponse response){
    List<UserInfo> list=userService.selectAll();
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
            UserInfo users=list.get(i-1);
            HSSFCell cell=r.createCell(0);
            cell.setCellValue(users.getUid());

            HSSFCell cell1=r.createCell(1);
            cell1.setCellValue(users.getUname());
            HSSFCell cell2=r.createCell(2);
            cell2.setCellValue(users.getUflag());
            HSSFCell cell3=r.createCell(3);
            cell3.setCellValue(users.getUpwd());
            HSSFCell cell4=r.createCell(4);
            cell4.setCellValue(users.getUimg());
            HSSFCell cell5=r.createCell(5);
            cell5.setCellValue(users.getUnum().getFname());
        }
        response.setContentType("application/x-download");
        response.setHeader("Content-Disposition", "attachment;filename=user.xls");
        OutputStream out =response.getOutputStream();
        wb.write(out);
        out.close();
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
        return null;
}
@RequestMapping("/delUser")
public String delUser(UserInfo userInfo,HttpSession session,HttpServletRequest request){

        UserInfo userInfo1=(UserInfo) session.getAttribute("userses");
        int c=userInfo1.getUnum().getFid();
    System.out.println(c+"====c");
        FamllyInfo famllyInfo=new FamllyInfo();
        famllyInfo.setFid(c);
        userInfo.setUnum(famllyInfo);
    System.out.println("userinfo==="+userInfo.getUnum().getFid());
        List<UserInfo> list=userService.byName(userInfo);
        int a=userInfo.getUflag();
    System.out.println("a===="+a);
        int b=list.size();
        System.out.println("b===="+b);
        if(a==1){
            if(b!=1){
                System.out.println("用户删除失败");
                return "redirect:/allFamlly?id="+2;
            }else{
                System.out.println("用户删除成功");
                int aa=userInfo.getUid();
                userService.delUser(aa);
                return "redirect:/allFamlly?id="+2;
            }
        }
    System.out.println("用户删除成功");
    int aa=userInfo.getUid();
    userService.delUser(aa);
    return "redirect:/allFamlly?id="+2;

}
@RequestMapping("/byIdUser")
public String byIdUser(UserInfo userInfo,Model model){
        UserInfo user=userService.byIdUser(userInfo);
        System.out.println("根据id查用户"+user.getUname());
        model.addAttribute("userById",user);
        return "updateUser";
}
@RequestMapping("/update")
public String update(UserInfo userInfo,@RequestParam("filename") MultipartFile file,HttpServletRequest request) throws IOException {

    String path=request.getServletContext().getRealPath("/img");
    String fileName=file.getOriginalFilename();
    userInfo.setUimg(fileName);
    File filename=new File(path,fileName);
    if(!filename.getParentFile().exists()){
        filename.getParentFile().mkdirs();
    }
    file.transferTo(filename);
        userService.updateUser(userInfo);
        System.out.println("修改"+userInfo.getUname());
        //return "redirect:/allUser?a="+a;
        return "redirect:/ByName";
}
@RequestMapping("/allUser")
public String allUser(Model model){
        List<UserInfo> list=userService.selectAll();
        model.addAttribute("alluser",list);
        return "userList";
}
@RequestMapping("/ByName")
public String ByName(Model model,HttpSession session){
    System.out.println("成员");
        UserInfo userInfo=(UserInfo)session.getAttribute("userses");
    System.out.println("chengyuan查"+userInfo.getUnum().getFid());
        List<UserInfo> list=userService.byName(userInfo);
    System.out.println("成员查询"+list.get(0).getUnum().getFid());
        int a=list.size();
        model.addAttribute("alluser",list);
        model.addAttribute("user",userInfo);
        model.addAttribute("a",a);
        return "userList";
    }
@RequestMapping("/addUser")
    public String addUser(@RequestParam("filename") MultipartFile file, HttpServletRequest request,Model model, UserInfo userInfo) throws IOException {
        int aa=userInfo.getUnum().getFid();
        String bb=request.getParameter("fpwd");
    System.out.println("页面接的家庭名字"+aa);
    System.out.println("页面接的密码"+bb);
        FamllyInfo famllyInfo=famllyService.selectByNameAndPwd(aa,bb);
        if(famllyInfo!=null){
            List<UserInfo> userInfo1=userService.byName(userInfo);
            if(userInfo1.size()>5){
                return "redirect:/allFamlly?id="+1;
            }else{
            System.out.println("tian加用户");
                System.out.println("家庭id"+userInfo.getUnum().getFid());
            List<UserInfo> list =userService.byName(userInfo);
                System.out.println("集合长度"+list.size());
            int a=list.size()==0?1:0;;//家主：成员
                userInfo.setUflag(a);
            String path=request.getServletContext().getRealPath("/img");
            String fileName=file.getOriginalFilename();
            userInfo.setUimg(fileName);
            File filename=new File(path,fileName);
            if(!filename.getParentFile().exists()){
                filename.getParentFile().mkdirs();
            }
            file.transferTo(filename);
            System.out.println("添加用户完成");
            userService.addUser(userInfo);
            return "index";
        }}
        System.out.println("密钥错误");
       return "redirect:/allFamlly?id="+1;
}
    @RequestMapping("/adUser")
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
    }
}


