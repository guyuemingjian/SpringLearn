package tradition.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tradition.dao.GetData;
import tradition.dao.beans.Test;

/**
 * 
 * @Describe:</br>
 * 				页面初期化</br>
 *
 * @author Administrator</br>
 * @CreateBy:2018年10月13日</br>
 *
 */
public class LieBiaoYe extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LieBiaoYe() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//列表页初期化数据全显示
		GetData gData = new GetData();
		//查询全表
		List<Test> tList = gData.getData();
		System.out.println(tList.toString());
		//返回页面数据
		request.setAttribute("data", tList);
		//跳转
		request.getRequestDispatcher("/WEB-INF/tradition/LieBiaoYe.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//取得参数
		String c1 = request.getParameter("c1");
		String c2 = request.getParameter("c2");
		System.out.println(c1 + "," + c2 );
		//列表页数据取得
		GetData gData = new GetData();
		//查询
		List<Test> tList = gData.getSearchData(c1, c2);
		System.out.println(tList.toString());
		//返回页面数据
		request.setAttribute("c1", c1);
		request.setAttribute("c2", c2);
		request.setAttribute("data", tList);
		//跳转
		request.getRequestDispatcher("/WEB-INF/tradition/LieBiaoYe.jsp").forward(request, response);
	}

}
