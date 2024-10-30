package com.comso.backend_spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.comso.backend_spring.entity.BoardListViewEntity;
import com.comso.backend_spring.repository.resultSet.GetUserBoardCategoryResultSet;

@Repository
public interface BoardListViewRepository extends JpaRepository<BoardListViewEntity, Integer> {
    
    List<BoardListViewEntity> findDisticByBoardNumberInOrderByWriteDatetimeDesc(List<Integer> distinctBoardNumberList);
    List<BoardListViewEntity> findByOrderByFavoriteCountDesc();
    List<BoardListViewEntity> findByOrderByViewCountDesc();

    @Query(
        value = 
        "SELECT * " +
        "FROM ( " +
        "   SELECT *, " +
        "       ROW_NUMBER() OVER(PARTITION BY board_number ORDER BY category_number) AS selected_board_number " +
        "FROM board_list_view " +
        ") AS result " +
        "WHERE selected_board_number = 1 " +
        "AND writer_email = ?1",
        nativeQuery = true
    )
    List<BoardListViewEntity> findByWriterEmailDistinctBoardNumber(String writerEmail);

    @Query(
        value = 
        "SELECT blv.category_number as categoryNumber, c.category_name as categoryName, COUNT(blv.board_number) as postCount " +
        "FROM board_list_view blv " +
        "JOIN category c ON blv.category_number = c.category_number " +
        "WHERE blv.writer_email = :writerEmail " +
        "GROUP BY blv.category_number, c.category_name",
        nativeQuery = true
    )
    List<BoardListViewEntity> getUserBoardCategory(String writerEmail);
    
    

    @Query(
        value = 
        "SELECT * " +
        "FROM ( " +
        "   SELECT *, " +
        "       ROW_NUMBER() OVER(PARTITION BY board_number ORDER BY category_number) AS selected_board_number " +
        "FROM board_list_view " +
        ") AS result " +
        "WHERE selected_board_number = 1 " +
        "ORDER BY " +
        "   CASE WHEN ?1 = 'view_count' THEN view_count END DESC, " +
        "   CASE WHEN ?1 = 'write_datetime' THEN write_datetime END DESC," +
        "   CASE WHEN ?1 = 'favorite_count' THEN favorite_count END DESC ",
        nativeQuery = true
    )
    List<BoardListViewEntity> getBoardListView(String order);

    @Query(
        value = 
        "SELECT * " +
        "FROM ( " +
        "   SELECT *, " +
        "       ROW_NUMBER() OVER(PARTITION BY board_number ORDER BY category_number) AS selected_board_number " +
        "FROM board_list_view " +
        "WHERE category_number IN ?1 " +
        ") AS result " +
        "WHERE selected_board_number = 1 " +
        "ORDER BY " +
        "   CASE WHEN ?2 = 'view_count' THEN view_count END DESC, " +
        "   CASE WHEN ?2 = 'write_datetime' THEN write_datetime END DESC, " +
        "   CASE WHEN ?2 = 'favorite_count' THEN favorite_count END DESC ",
        nativeQuery = true
    )
    List<BoardListViewEntity> getCategoryBoardListView(List<Integer> selectedCategoryList, String order);

    @Query(
        value = 
        "SELECT * " +
        "FROM ( " +
        "   SELECT *, " +
        "       ROW_NUMBER() OVER(PARTITION BY board_number ORDER BY write_datetime DESC) AS row_num " +
        "   FROM board_list_view " +
        "   WHERE title LIKE %:title% OR content LIKE %:content% " +
        ") AS filtered " +
        "WHERE filtered.row_num = 1 " +
        "ORDER BY write_datetime DESC",
        nativeQuery = true
    )
    List<BoardListViewEntity> findByTitleContainsOrContentContainsOrderByWriteDatetimeDesc(@Param("title") String title,
    @Param("content") String content);

    @Query(
        value = 
        "SELECT c.category_name AS categoryName, COUNT(blv.board_number) AS categoryCount " +
        "FROM board_list_view blv " +
        "JOIN category c ON blv.category_number = c.category_number " +
        "WHERE blv.writer_email = ?1 " +
        "GROUP BY c.category_number, c.category_name",
        nativeQuery = true
        )
    List<GetUserBoardCategoryResultSet> getCategoryBoardCountForUser(String userEmail);
}
