package com.getsecual.shop.payment;

import com.gmo_pg.g_pay.client.common.PaymentException;

/**
 * GMOPGラッパークラス
 *
 * @author
 *
 */
public class GMOPaymentWrapper {

	/**
	 * 支払い処理実行
	 *
	 * @param com.getsecual.shop.payment.PaymentGatewayConfiguration
	 * @throws com.gmo_pg.g_pay.client.common.PaymentException
	 */
	public void executePayment(PaymentGatewayConfiguration paymentGatewayConfiguration) throws PaymentException {
		// 決済実行、実行内容はインターフェースの実装クラスによる
		try {
			paymentGatewayConfiguration.executePaymentGateway();
		} catch (PaymentException paymentException) {
			// APIのエラーはそのままスローする
			throw paymentException;
		} catch (Exception exception) {
			// その他のエラーはラップしてスローする
			throw new PaymentException(exception);
		}
	}

}
