package com.samanecorp.orienta.controller;

import com.samanecorp.orienta.entities.PayTech;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@WebServlet("/requestPayment")
public class PaymentController extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        String idTransaction = req.getParameter("idTransaction");
        int amount = 5000;

        String paymentTitle = String.format("Paiment facture № %s de %s FCFA", idTransaction, amount);
        String jsonResult = PayTech.sendPaymentRequest(idTransaction, amount, paymentTitle);

        PrintWriter out = response.getWriter();

        out.print(jsonResult);
        out.flush();
    }
}
