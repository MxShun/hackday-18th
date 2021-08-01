package com.kitteless.kittelessfront.repository;

import com.kitteless.kittelessfront.data.PaymentDataResponse;
import jp.ne.paypay.ApiClient;
import jp.ne.paypay.Configuration;
import jp.ne.paypay.api.PaymentApi;
import jp.ne.paypay.model.MoneyAmount;
import jp.ne.paypay.model.QRCode;
import jp.ne.paypay.model.QRCodeDetails;
import org.springframework.stereotype.Repository;

@Repository
public class PaypayRepository {

    public String call (String userId, int price) {

        try{

            ApiClient apiClient = new Configuration().getDefaultApiClient();
            //Set True for Production Environment. By Default this is set False for Sandbox Environment.
            apiClient.setProductionMode(false);
            apiClient.setApiKey("a_IY5mdJ6fB1_YRCJ");
            apiClient.setApiSecretKey("YHbiSKQ4nzL4SXEuO9D/GY14TiT5729St30vyBITJmc=");

            QRCode qrCode = new QRCode();
            qrCode.setAmount(new MoneyAmount().amount(price).currency(MoneyAmount.CurrencyEnum.JPY));
            qrCode.setMerchantPaymentId("my_payment_id");
            qrCode.setCodeType("ORDER_QR");
            qrCode.setOrderDescription("Kitteless");
            qrCode.isAuthorization(false);
            qrCode.setRedirectUrl("https://localhost:8080/payment/");
            qrCode.setRedirectType(QRCode.RedirectTypeEnum.WEB_LINK);
            qrCode.setUserAgent("Mozilla/5.0 (iPhone; CPU iPhone OS 10_3 like Mac OS X) AppleWebKit/602.1.50 (KHTML, like Gecko) CriOS/56.0.2924.75 Mobile/14E5239e Safari/602.1");

            // Calling the method to create a qr code
            PaymentApi apiInstance = new PaymentApi(apiClient);
            QRCodeDetails response = apiInstance.createQRCode(qrCode);
            // Printing if the method call was SUCCESS
            System.out.println(response.getResultInfo().getCode());
        } catch (Exception e) {
            System.out.println(e);
        }

        return null;
    }

}
