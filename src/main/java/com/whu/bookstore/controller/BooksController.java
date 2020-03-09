package com.whu.bookstore.controller;

import com.whu.bookstore.Util.PictureUtil;
import com.whu.bookstore.common.Result;
import com.whu.bookstore.service.IBooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

/**
 * @author ：qx.w
 * @description：书籍类接口
 * @modified By：
 * @since ：Created in 2020/2/26 20:32
 */
@RestController
@RequestMapping("/books")
public class BooksController {
    @Autowired
    IBooksService booksService;

    @PostMapping(value = "/aBook")
    public Result uploadABook(@RequestParam("name") String name,
                              @RequestParam("author") String author,
                              @RequestParam("press") String press,
                              @RequestParam("sort") String sort,
                              @RequestParam("price") double price,
                              @RequestParam("stock") int stock,
                              @RequestParam("description") String description,
                              @RequestParam("image") MultipartFile image) {
        Result result = new Result();

        String uuid = UUID.randomUUID().toString(); //生成UUID
        //得到图片url
        String url = PictureUtil.uploadImage(image, uuid, PictureUtil.filePathBook);
        if (url.equals("上传失败，请上传bmp、jpg、jpeg、png、gif文件！")){
            result.setCode(500);
            result.setMsg(url);
            return result;
        }else if (url.equals("图片上传至服务器失败！")){
            result.setCode(500);
            result.setMsg(url);
            return result;
        }
        try {
            booksService.insertBook(uuid, name, author, press, sort, price, stock, description, url);
            result.setMsg("上传成功！");
        }
        catch (Exception e) { //上传数据库失败则删除那张图片
//            objService.deletePhoto(uuid, url);
            result.setMsg("上传失败，数据库写入失败！");
        }
        return result;

    }


    @GetMapping(value = "/allBook/{sort}")
    public Result getBookBySort(@PathVariable("sort") String sort) {
        Result result = new Result();
        if (sort.equals("all")) {
            sort = null;
        }
        try {
            result.setData(booksService.getBookVoBySort(sort));
            result.setCode(200);
            result.setMsg("成功");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            result.setCode(500);
        }
        return result;

    }

    @GetMapping(value = "/aBook/{uuid}")
    public Result getBookByUuid(@PathVariable("uuid") String uuid) {
        Result result = new Result();
        try {
            result.setData(booksService.getBookByUuid(uuid));
            result.setCode(200);
            result.setMsg("成功");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            result.setCode(500);
        }
        return result;

    }

    @GetMapping(value = "/someBook/{sort}")
    public Result getBookLikeName(@RequestParam("name") String name,
                                  @PathVariable("sort") String sort) {
        Result result = new Result();
        if (sort.equals("all")) {
            sort = null;
        }
        try {
            result.setData(booksService.getBookVoLikeName(name, sort));
            result.setCode(200);
            result.setMsg("成功");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            result.setCode(500);
        }
        return result;
    }

    @PutMapping(value = "/aBook/{uuid}")
    public Result updateBookByUuid(@PathVariable("uuid") String uuid,
                                   @RequestParam("name") String name,
                                   @RequestParam("author") String author,
                                   @RequestParam("press") String press,
                                   @RequestParam("sort") String sort,
                                   @RequestParam("price") double price,
                                   @RequestParam("stock") int stock,
                                   @RequestParam("description") String description,
                                   @RequestParam("image") MultipartFile image) {
        Result result = new Result();

        String url = booksService.getBookByUuid(uuid).get(0).getImage();
        //首先判断删除老图片是否成功
        if (!PictureUtil.deletePhoto(url, PictureUtil.filePathBook)) {
            result.setCode(500);
            result.setMsg("更新失败（ps:删除）");
        }
        //得到图片url
        url = PictureUtil.uploadImage(image, uuid, PictureUtil.filePathBook);
        if (url.equals("上传失败，请上传bmp、jpg、jpeg、png、gif文件！")){
            result.setCode(500);
            result.setMsg(url);
            return result;
        }else if (url.equals("图片上传至服务器失败！")){
            result.setCode(500);
            result.setMsg(url);
            return result;
        }
        try {
            int count = booksService.updateBook(uuid, name, author, press, sort, price, stock, description, url);
            result.setMsg("更新成功！");
            result.setCode(200);
            result.setData(count);
        }
        catch (Exception e) { //上传数据库失败则删除那张图片
//            objService.deletePhoto(uuid, url);
            result.setCode(500);
            result.setMsg("更新失败，数据库写入失败！");
        }
        return result;
    }

    @DeleteMapping(value = "/aBook/{uuid}")
    public Result deleteBookByUuid(@PathVariable("uuid") String uuid) {
        Result result = new Result();

        String url = booksService.getBookByUuid(uuid).get(0).getImage();
        //首先判断删除老图片是否成功
        if (!PictureUtil.deletePhoto(url, PictureUtil.filePathBook)) {
            result.setCode(500);
            result.setMsg("删除失败（ps:图片）");
        }
        try {
            int count = booksService.deleteBook(uuid);
            result.setData(count);
            result.setMsg("成功，删除条数为data");
            result.setCode(200);
        }
        catch (Exception e) {
            result.setMsg("失败，数据库操作失败");
            result.setCode(500);
        }
        return result;
    }

}
