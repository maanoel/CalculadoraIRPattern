/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CalculadoraController;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author aluno
 */
public class CalculadoraIRServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /*response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
           
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CalculadoraIRServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CalculadoraIRServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {            
            out.close();
        }*/
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        Double descontosIR;
        Double descontosInss;
        Double outrosDesc = 0.0;
        Double referencia = 0.0;
        String nome = request.getParameter("nome");
        Double salario = Double.parseDouble(request.getParameter("salario"));
        Double aux;
        if(!request.getParameter("outrosDesc").equals("")){
            outrosDesc = Double.parseDouble(request.getParameter("outrosDesc"));
        }
        
        descontosInss = calcularINSS(salario);
       
        aux = salario - descontosInss;
        
        if (aux>=1903.99 && aux <=2826.65) {
            aux = aux*0.075 - 142.80;  
            referencia = 7.5;
        } else if (aux>=2826.66 && aux <=3751.05){
            aux = aux*0.15 - 354.80;       
            referencia = 15.0;
        } else if (aux>=3751.06 && aux <=4664.68){
            aux = aux*0.225 - 636.13;
            referencia = 22.5;
        } else if (aux>4664.68){
            aux = aux*0.275 - 869.36;
            referencia = 27.5;
        }
        
        BigDecimal IR = new BigDecimal(aux);
        IR = IR.setScale(2, BigDecimal.ROUND_HALF_EVEN);
               
        descontosIR = IR.doubleValue();       
        descontosInss = Math.ceil(descontosInss);  
        salario = salario - descontosIR - descontosInss - outrosDesc;
       
        response.sendRedirect( "calculoIR.jsp?nome=" + nome + "&sal=" + salario.toString() + "&ir=" + descontosIR.toString() + "&inss=" + descontosInss.toString() + "&ref=" + referencia.toString() );
    }
    
    public double calcularINSS(double pSalario){
        
        Double desc = 0.0;
        
        if (pSalario<=1659.38) {
            desc = pSalario*0.08;
        }else if (pSalario >= 1659.39 && pSalario <=2765.66){
            desc = pSalario*0.09;
        } else if (pSalario >= 2765.67 && pSalario <=5531.31){
            desc = pSalario*0.11;
        } 
        
        return desc;
    }
    
     /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
