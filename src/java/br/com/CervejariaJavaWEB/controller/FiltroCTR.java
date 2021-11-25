package br.com.CervejariaJavaWEB.controller;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@WebFilter(filterName = "FiltroCTR", urlPatterns = {"/*"})
public class FiltroCTR implements Filter {
    
    private static final boolean debug = true;

    private FilterConfig filterConfig = null;
    
    public FiltroCTR() {
    }    
    
    private void doBeforeProcessing(ServletRequest request, ServletResponse response)
            throws IOException, ServletException {
        if (debug) {
            log("FiltroCTR:DoBeforeProcessing");
        }

    }    
    
    private void doAfterProcessing(ServletRequest request, ServletResponse response)
            throws IOException, ServletException {
        if (debug) {
            log("FiltroCTR:DoAfterProcessing");
        }

    }
    
    //  METODO PARA FILTRAR O ACESSO AS PÁGINAS ADMINISTRADORAS
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        
        HttpServletRequest req = (HttpServletRequest) request;
        String URL = req.getRequestURI();       //  OBTENDO O FINAL DAS URL's
        Boolean acesso = false;                 //  CONTROLE DO ACESSO

        //  LISTA DE EXCEÇÕES
        String[] excessao = {
            "/",
            ".css",
            ".js",
            ".jpg",
            ".jpeg",
            ".png",
            ".gif",
            ".eot",
            ".otf",
            ".svg",
            ".ttf",
            ".woff",
            ".woff2",
            ".scss",
            ".html",
            ".txt",
            ".pdf",
            ".xml",
            "index.jsp",
            "form_register.jsp",
            "form_login.jsp",
            "error.jsp",
            "CadastrarAdminCTR",
            "LogarAdminCTR",
            "SugestaoCTR",
        };
        
        //  VERIFICAÇÃO DA URL
        for(String item : excessao){
            if(URL.endsWith(item)){
                acesso = true;
            }
        }
        
        //  VERIFICANDO SE CONTÉM SESSÃO ATIVA
        HttpSession session = req.getSession();
        if(session.getAttribute("sessaoAdmin") != null){
            acesso = true;
        }
        
        //  VERIFICANDO ACESSO FINAL
        if(acesso){
            chain.doFilter(request, response);  //  ESSA É A LINHA QUE VAI LIBERAR O ACESSO AS INFORMAÇÕES
        }else{
            req.setAttribute("mensagem", "Acesso negado.");
            req.getRequestDispatcher("form_login.jsp").forward(request, response);
        }
        
    }

    public FilterConfig getFilterConfig() {
        return (this.filterConfig);
    }

    public void setFilterConfig(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }

    public void destroy() {        
    }

    public void init(FilterConfig filterConfig) {        
        this.filterConfig = filterConfig;
        if (filterConfig != null) {
            if (debug) {                
                log("FiltroCTR:Initializing filter");
            }
        }
    }

    @Override
    public String toString() {
        if (filterConfig == null) {
            return ("FiltroCTR()");
        }
        StringBuffer sb = new StringBuffer("FiltroCTR(");
        sb.append(filterConfig);
        sb.append(")");
        return (sb.toString());
    }
    
    private void sendProcessingError(Throwable t, ServletResponse response) {
        String stackTrace = getStackTrace(t);        
        
        if (stackTrace != null && !stackTrace.equals("")) {
            try {
                response.setContentType("text/html");
                PrintStream ps = new PrintStream(response.getOutputStream());
                PrintWriter pw = new PrintWriter(ps);                
                pw.print("<html>\n<head>\n<title>Error</title>\n</head>\n<body>\n"); //NOI18N

                pw.print("<h1>The resource did not process correctly</h1>\n<pre>\n");                
                pw.print(stackTrace);                
                pw.print("</pre></body>\n</html>"); //NOI18N
                pw.close();
                ps.close();
                response.getOutputStream().close();
            } catch (Exception ex) {
            }
        } else {
            try {
                PrintStream ps = new PrintStream(response.getOutputStream());
                t.printStackTrace(ps);
                ps.close();
                response.getOutputStream().close();
            } catch (Exception ex) {
            }
        }
    }
    
    public static String getStackTrace(Throwable t) {
        String stackTrace = null;
        try {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            t.printStackTrace(pw);
            pw.close();
            sw.close();
            stackTrace = sw.getBuffer().toString();
        } catch (Exception ex) {
        }
        return stackTrace;
    }
    
    public void log(String msg) {
        filterConfig.getServletContext().log(msg);        
    }
    
}
