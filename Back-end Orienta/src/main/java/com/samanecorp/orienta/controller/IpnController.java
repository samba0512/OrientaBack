package com.samanecorp.orienta.controller;

import com.samanecorp.orienta.entities.PayTech;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/paymentIpn")
public class IpnController extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse
            response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try {
            if(PayTech.ipnFromPayTech(req)){
                String idTransaction = req.getParameter("custom_field");
                String amount = req.getParameter("item_price");
                String paymentMethod = req.getParameter("payment_method");
              //todo here update transaction status to solded
                out.print("IPN OK");
            }
            else{
                out.print("IPN KO NOT FROM PAYTECH");
            }
        } catch (Exception e) {
            e.printStackTrace();
            out.print(e.getMessage());
        }
        out.flush();
    }
}
