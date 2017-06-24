package com.netease.sellsystem.action;

import com.alibaba.fastjson.JSON;
import com.netease.sellsystem.bean.ContentBean;
import com.netease.sellsystem.dao.ContentDao;
import com.netease.sellsystem.utils.MD5Code;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by Shaun on 2017/3/8 0008.
 */
@Controller
@RequestMapping("/content")
public class ContentAction {
    @Autowired
    private ContentDao contentDaoImpl;

    @RequestMapping("/getContentList.do")
    public String getContentList(int page, String type, Model model, HttpServletRequest request) {
        int pageSize = 10;

        int totalPage = contentDaoImpl.getTotalPage(pageSize);
        if (totalPage == 0) totalPage = 1;
        page=normalizePage(page,totalPage);

        List<ContentBean> contentList = null;
        try {
            contentList = (List<ContentBean>) contentDaoImpl.getContents(pageSize, page);
        } catch (Exception e) {
            request.setAttribute("err_msg", "获取内容列表失败！");
        }
        model.addAttribute("contentList", JSON.toJSONString(contentList));
        model.addAttribute("totalPage", totalPage);
        model.addAttribute("page", page);
        if (type.equals("1")) {
            return "/view/buyerNews.jsp";
        } else {
            return "/view/newsctrl.jsp";
        }
    }

    @RequestMapping("/getNonBoughtList.do")
    public String getNonBoughtList(int page, Model model, HttpServletRequest request) {

        int pageSize = 10;

        int totalPage = contentDaoImpl.getNonBoughtTotalPage(pageSize);
        if (totalPage == 0) totalPage = 1;
        page=normalizePage(page,totalPage);

        List<ContentBean> contentList = null;
        try {
            contentList = (List<ContentBean>) contentDaoImpl.getNonBought(pageSize, page);
        } catch (Exception e) {
            request.setAttribute("err_msg", "获取内容列表失败！");
        }

        model.addAttribute("contentList", JSON.toJSONString(contentList));
        model.addAttribute("totalPage", totalPage);
        model.addAttribute("page", page);
        return "/view/buyerNews.jsp";
    }

    private int normalizePage(int page, int totalPage) {
        if (page < 1) {
            page = 1;
        } else if (page > totalPage) {
            page = totalPage;
        }
        return page;
    }

    @RequestMapping("/addContent.do")
    public String addInformation(String content, String summary, String title, int price, @RequestParam("imgfile") CommonsMultipartFile imgfile,
                                 HttpSession session, RedirectAttributes redirectAttributes) {
        if (title == null || content == null
                || title.trim().equals("") || content.trim().equals("")) {
            redirectAttributes.addFlashAttribute("err_information", "不能为空");
            return "redirect:/content/getContentList.do?page=1";
        }

        try {
            ContentBean contentBean = new ContentBean();
            contentBean.setTitle(title);
            contentBean.setContentPic(getPicPath(imgfile, session));
            contentBean.setContentId(MD5Code.getMD5("contentId" + System.currentTimeMillis()));
            contentBean.setSummary(summary);
            contentBean.setText(content);
            contentBean.setUserId((String) session.getAttribute("username"));
            contentBean.setPrice(price);
            contentBean.setSaleQuantity(0);

            contentDaoImpl.saveContent(contentBean);
            redirectAttributes.addFlashAttribute("err_information", "添加内容成功");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("err_information", "添加内容失败");
        }

        return "redirect:/content/getContentList.do?page=1&type=0";
    }

    @RequestMapping("/deleteContent.do")
    public String deleteContent(String nid) {
        contentDaoImpl.deleteContent(nid);
        return "redirect:/content/getContentList.do?page=1&type=0";
    }

    @RequestMapping("/editContent.do")
    public String editContent(String contentId, String summary, String content, String title, @RequestParam("imgfile") CommonsMultipartFile imgfile, int price
            , HttpSession session, RedirectAttributes redirectAttributes) {
        try {
            ContentBean contentBean = contentDaoImpl.getContentById(contentId);
            contentBean.setTitle(title);
            contentBean.setSummary(summary);
            contentBean.setContentPic(getPicPath(imgfile, session));
            contentBean.setText(content);
            contentBean.setPrice(price);

            contentDaoImpl.updateContent(contentBean);
            redirectAttributes.addFlashAttribute("err_information", "编辑内容成功");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("err_information", "编辑内容失败");
        }
        return "redirect:/content/getContentList.do?page=1&type=0";
    }

    private String getPicPath(CommonsMultipartFile imgfile, HttpSession session) {
        String path = session.getServletContext().getRealPath("/upload/contentPic");
        String filePath = "";
        if (imgfile.getSize() != 0) {
            try {
                String filename = imgfile.getOriginalFilename();
                FileUtils.writeByteArrayToFile(new File(path, filename), imgfile.getBytes());
                filePath = "/upload/contentPic/" + filename;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return filePath;
    }
}
