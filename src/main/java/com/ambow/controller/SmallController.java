package com.ambow.controller;

import com.ambow.bean.BigInfo;
import com.ambow.bean.PageInfo;
import com.ambow.bean.SmallInfo;
import com.ambow.bean.UserInfo;
import com.ambow.service.BigService;
import com.ambow.service.SmallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class SmallController {
@Autowired
    private SmallService smallService;
@Autowired
    private BigService bigService;
    @RequestMapping("/allSmall")
    public String allSmall(Model model, HttpSession session){
        List<SmallInfo> list=smallService.selectAll();
        System.out.println("查所有小类");
        UserInfo user=(UserInfo) session.getAttribute("userses");
        System.out.println("大类返回用户"+user.getUname());
        model.addAttribute("user",user);
        model.addAttribute("allSmall",list);
        int a=1;
        return "redirect:/smallListPage";
    }
    @RequestMapping("/addSmall")
    public String addSmall(SmallInfo smallInfo){
        System.out.println("dfjkajioikj");
        SmallInfo smallInfo1=smallService.selectNameAndType(smallInfo);
        if(smallInfo1!=null){
            System.out.println("未加小类值");
            return "redirect:/allSmall";
        }else{
            smallService.addSmall(smallInfo);
            return "redirect:/allSmall";
        }
    }
    @RequestMapping("/delSmall")
    public String delSmall(int id,Model model,String aa){
        smallService.delSmall(id);
        return "redirect:/allSmall";
    }
    @RequestMapping("/byIdSmall")
    public String byIdSmall(SmallInfo smallInfo,Model model){
        System.out.println("查小类对应大类");
        SmallInfo small=smallService.byIdSmall(smallInfo);
        List<BigInfo> list=bigService.selectAll();
        System.out.println("根据id查dalei"+list.get(0).getBname());
        model.addAttribute("allBig",list);
        model.addAttribute("smallById",small);
        return "updateSmall";
    }
    @RequestMapping("/updateSmall")
    public String update(SmallInfo smallInfo){
        SmallInfo smallInfo1=smallService.selectNameAndType(smallInfo);
        if(smallInfo1!=null){
            return "redirect:/smallListPage";
        }else{
            smallService.updateSmall(smallInfo);
            System.out.println("修改"+smallInfo.getSname());
            return "redirect:/smallListPage";
        }

    }
    @RequestMapping("/smallListPage")
    public String smallListPage(Model model, HttpServletRequest request,HttpSession session){
        String page=request.getParameter("page");
        System.out.println("分页");
        int yetiao = 3 ;
        if(page==null){
            page =1+"";
        }
        UserInfo user=(UserInfo) session.getAttribute("userses");
        System.out.println("小类返回用户"+user.getUname());
        model.addAttribute("user",user);
        List<SmallInfo> list=smallService.allSmallServicePage((Integer.parseInt(page)-1)*yetiao,yetiao);
        System.out.println("service没问题");
        /*for(SmallInfo items:list){
            System.out.println("大类名"+items.getBsid().getBname());
        }*/
        model.addAttribute("listSmall", list);
        model.addAttribute("page", page);
        PageInfo pageInfo=new PageInfo();
        pageInfo.setDangPage(Integer.parseInt(page));
        pageInfo.setYeTiao(yetiao);
        List<SmallInfo> list1=smallService.selectAll();
        int allNum=list1.size();
        System.out.println("list2..."+list1.size());
        pageInfo.setTotalTiao(allNum);//总条数，数据库一共多少条
        model.addAttribute("lastPage", pageInfo.getTotalPage());
        return "smallList";
    }
}
