package com.bookapp.model.web.controller;
import java.util.*;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookapp.model.dao.Book;
import com.bookapp.model.service.BookService;
import com.bookapp.model.service.BookServiceImpl;


@WebServlet("/bookController")
public class BookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private BookService bookService;
   
   
	public BookController() {
		bookService=new BookServiceImpl();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Book> books=bookService.getAll();
		
		request.setAttribute("books", books);
		RequestDispatcher rd=request.getRequestDispatcher("show.jsp");
		rd.forward(request, response);
		
	}

	

}
