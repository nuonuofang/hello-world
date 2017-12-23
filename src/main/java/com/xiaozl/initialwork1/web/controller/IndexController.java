package com.xiaozl.initialwork1.web.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xiaozl.initialwork1.entity.User;
import com.xiaozl.initialwork1.service.UserService;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * @author fanghl
 * @date 2017/11/20
 */
@Controller//标注这是一个控制类，类名不能和注解名一样
@RequestMapping(value = "")//设置访问路径
public class IndexController {

    @Resource
    private UserService userService;

    @RequestMapping(value = {"", "/", "login"}, method = RequestMethod.GET)
    public String toLogin(HttpServletRequest request) {
        //If session have attribute "user", jump to index page, else jump to login page.
        if (request.getSession().getAttribute("user") != null) {
            return "index";
        } else {
            return "login";
        }
    }

    @RequestMapping(value = {"register"}, method = RequestMethod.GET)
    public String toRegister() throws Exception {
        return "register";
    }

    //Login
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(User user, Model model, HttpServletRequest request) throws Exception {
        try {
            //If pass, set attribute to session, then redirect to index page.
            if (userService.checkLogin(user)) {
                request.getSession().setAttribute("user", user);
                model.addAttribute("user", user);
                return "index";
            }
            //If not pass, send error attribute.
            else {
                model.addAttribute("login_err", "登录失败!");
                return "login";
            }
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "login";
        }
    }

    //logout
    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request) throws Exception {
        request.getSession().removeAttribute("userName");
        return "login";
    }

    //Register
    @RequestMapping(value = "register", method = RequestMethod.POST)
    public String register(User user, Model model) throws Exception {
        try {
            User user2 = userService.newUser(user);
            if (user2 != null)
                return "login";
        } catch (Exception e) {
            model.addAttribute("register_err", "注册失败!");
        }
        return "register";
    }
    /**
     * 遍历所有用户
     * @param model
     * @return
     */
    @RequestMapping(value = "main", method = RequestMethod.GET)//超链接只能用post
    public String userList(Model model) {

          try{
            List<User> userList = userService.findAll();
            model.addAttribute("userList", userList);
            return "UserList";
        } catch (Exception e) {
            return null;
        }
    }
    /**
     * 删除
     * @param id
     * @param redirectAttributes
     * @return
     */
    @RequestMapping(value = "del/{id}", method = RequestMethod.GET)
    public String del(@PathVariable("id") int id,RedirectAttributes redirectAttributes){
        try{
            userService.delete(id);//接方法名
           // redirectAttributes.addFlashAttribute("message", "删除成功！");
            return "redirect:/main";//重定向，对应control方法的路径
        } catch (Exception e) {
            return null;
        }
    }

//    /**
//     * 内容显示页面
//     * @param id
//     * @param model
//     * @return
//     */
//    @RequestMapping(value = "content/{id}",method = RequestMethod.GET)
//    public String content(@PathVariable("id") int id,Model model){
//        try{
//            User user = new User();
//            user = userService.findUserById(id);
//
//            model.addAttribute("user",user);
//            return "content";
//        } catch (Exception e) {
//
//            return null;
//        }
//    }

    /**
     * 跳转到更新页面
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "toUpdate/{id}",method = RequestMethod.GET)
    public String toUpdate(@PathVariable("id") int id,Model model)throws Exception{

//        try{
//            User  user = userService.findUserById(id);
////            model.addAttribute("list",userList(model));
//            model.addAttribute("user",user);
//            return "update_user";
//        } catch (Exception e) {
//
//            return null;
//        }
        User user = null;
        user = userService.findUserById(id);
        model.addAttribute("user", user);
        return "update_user";
    }

    /**
     * 更新
     * @param user
     * @param id
     * @param redirectAttributes
     * @return
     */
    @RequestMapping(value = "updateUser/{id}",method = RequestMethod.POST)
    public String updateUser(User user,@PathVariable("id") int id, Model model,RedirectAttributes redirectAttributes){
        try {
//            if(!Assert.isNotNull(user)){
//                return null;
//            }
//            redirectAttributes.addFlashAttribute("message","修改成功");
            int i=userService.update(user);
            return "redirect:/main";

        } catch (Exception e) {

            return null;
        }
    }

    /**
     * 跳转到增加页面
     * @param model
     * @return
     */
    @RequestMapping(value = "/toAdd",method = RequestMethod.GET)
    public String toAdd(Model model){
        try {
            model.addAttribute("list",userList(model));
            return "add_user";
        } catch (Exception e) {

            return null;
        }
    }

    /**
     * 增加
     * @param user
     * @param redirectAttributes
     * @return
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String add(User user,RedirectAttributes redirectAttributes){
        try {
            userService.newUser(user);
            redirectAttributes.addFlashAttribute("message", "添加成功！");
            return "redirect:/main";
        } catch (Exception e) {

            return null;
        }
    }
//
//    /**
//     * 通过关键字查用户
//     * @param keyword
//     * @param model
//     * @return
//     */
//    @RequestMapping(value = "/select",method = RequestMethod.POST)
//    public String select(@RequestParam("keyword")String keyword,Model model){
//        try {
//            if(!Assert.isNotNull(keyword)){
//                model.addAttribute("message","输入不能为空");
//                return "redirect:/user/main";
//            }
//            List<User> list = Collections.emptyList();
//            list = userService.queryByKeyword(keyword);
//            if(list.isEmpty()){
//                model.addAttribute("message","没有与搜索条件匹配的项");
//                return "select_user";
//            }
//            model.addAttribute("list",list);
//            return "select_user";
//        } catch (Exception e) {
//
//            return null;
//        }
//    }



}