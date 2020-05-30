/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import static javafx.beans.binding.Bindings.and;
import javax.annotation.Resource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
@PersistenceContext(name = "persistence/LogicalName", unitName = "Tugas_3PU")
@WebServlet(name = "QueryAverageSalary", urlPatterns = {"/QueryAverageSalary"})
public class QueryAverageSalary extends HttpServlet {
 @Resource
 private javax.transaction.UserTransaction utx;
 protected void processRequest(HttpServletRequest request, HttpServletResponse response)
 throws ServletException, IOException {
 response.setContentType("text/html;charset=UTF-8");
 PrintWriter out = response.getWriter();
 try {
 String n1 = "";
 if (request.getParameter("n1") != null) {
 n1 = request.getParameter("n1");
 }
 out.println("Masukkan Nama Departemen (HR, RD atau Sales)");
 out.println("<form method=\"post\" action=\"QueryAverageSalary\">");
 out.println("<input type=\"text\" name=\"n1\" value=\"" + n1 + "\"/>");
 out.println("<input type=\"submit\" value=\"Submit\" />");
 out.println("</form>");
 Context ctx = (Context) new InitialContext().lookup("java:comp/env");
 utx.begin();
 EntityManager em = (EntityManager) ctx.lookup("persistence/LogicalName");
 Query q;
     q = em.createNativeQuery("SELECT ROUND(AVG(Emp.SALARY),0) FROM Dept, Emp WHERE Emp.DEPT_DID = Dept.DID and Dept.Dname =?1");
 q.setParameter(1, n1);
 List r = q.getResultList();
 utx.commit();
 out.println("Rata - rata gaji Departemen " + n1.toUpperCase() + " adalah " + r );
 } catch (IllegalStateException | SecurityException | NamingException | HeuristicMixedException | HeuristicRollbackException | NotSupportedException | RollbackException | SystemException e) {
 }
 }}
