package com.kitteless.kittelessfront.repository;

import jp.ne.paypay.ApiClient;
import jp.ne.paypay.Configuration;
import jp.ne.paypay.api.PaymentApi;
import jp.ne.paypay.model.MoneyAmount;
import jp.ne.paypay.model.QRCode;
import jp.ne.paypay.model.QRCodeDetails;
import org.springframework.stereotype.Repository;

import java.time.Instant;

@Repository
public class PaypayRepository {

    public String call (String userId, int price) {

        try{

            ApiClient apiClient = createApiClient();
            QRCode qrCode = new QRCode();
            qrCode.setAmount(new MoneyAmount().amount(price).currency(MoneyAmount.CurrencyEnum.JPY));
            qrCode.setMerchantPaymentId(Instant.now().toString());
            qrCode.setCodeType("ORDER_QR");
            qrCode.requestedAt(Instant.now().getEpochSecond());
            qrCode.setOrderDescription("Kitteless で 切手を買うよ！");
            qrCode.isAuthorization(false);
            qrCode.setRedirectUrl("http://localhost:8080/entry");
            qrCode.setRedirectType(QRCode.RedirectTypeEnum.WEB_LINK);
            qrCode.setUserAgent("Mozilla/5.0 (iPhone; CPU iPhone OS 10_3 like Mac OS X) AppleWebKit/602.1.50 (KHTML, like Gecko) CriOS/56.0.2924.75 Mobile/14E5239e Safari/602.1");

            // Calling the method to create a qr code
            PaymentApi apiInstance = new PaymentApi(apiClient);
            QRCodeDetails response = apiInstance.createQRCode(qrCode);
            // Printing if the method call was SUCCESS
            System.out.println(response);
            return response.getData().getUrl();
        } catch (Exception e) {
            System.out.println(e);
        }

        return null;
    }

    private static ApiClient createApiClient() {
        try {
            ApiClient apiClient = new Configuration().getDefaultApiClient();
            apiClient.setProductionMode(false);
            apiClient.setApiKey("a_IY5mdJ6fB1_YRCJ");
            apiClient.setApiSecretKey("YHbiSKQ4nzL4SXEuO9D/GY14TiT5729St30vyBITJmc=");
            apiClient.setAssumeMerchant("403396290898518016");
            return apiClient;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

}
