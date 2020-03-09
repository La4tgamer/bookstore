package com.whu.bookstore.dao;

import com.whu.bookstore.common.BookVo;
import com.whu.bookstore.entity.Address;
import com.whu.bookstore.entity.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author ：qx.w
 * @description：书籍mapper层
 * @modified By：
 * @since ：Created in 2020/2/26 17:10
 */
@Mapper
public interface BooksMapper {

    /**
     * 通过类别查找所有书（简略信息）
     * @param sort
     * @return
     */
    List<BookVo> selectAllBySort(@Param("sort") String sort);

    /**
     * 通过uuid查找一本书（具体信息）
     * @param uuid
     * @return
     */
    List<Book> selectByUuid(@Param("uuid") String uuid);

//    @Param("name") String name,
//    @Param("author") String author,
//    @Param("press") String press,
//    @Param("sort") String sort,
//    @Param("price") double price,
//    @Param("stock") int stock,
//    @Param("description") String description,
//    @Param("image") String image

    /**
     * 新增一本书
     * @param book
     * @return
     */
    int insertBook(Book book);



    /**
     * 更新库存
     * @param uuid
     * @param num
     * @return
     */
    int updateStock(String uuid,int num);

    /**
     * 模糊查询书名
     * @param name
     * @return
     */
    List<BookVo> selectLikeName(@Param("name") String name, @Param("sort") String sort);

    /**
     * 修改一本书
     * @param book
     * @return
     */
    int updateBook(Book book);


    /**
     * 删除一本书
     * @param uuid
     * @return
     */
    int deleteBook(@Param("uuid") String uuid);



}



