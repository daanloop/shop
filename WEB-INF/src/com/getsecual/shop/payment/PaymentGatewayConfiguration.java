package com.getsecual.shop.payment;

import java.util.List;

import com.gmo_pg.g_pay.client.common.PaymentException;

/**
 * 決済処理のインターフェース
 * @author
 *
 */
public interface PaymentGatewayConfiguration {

	/**
	 * 決済の種類別に実装
	 * @throws PaymentException
	 */
	public void executePaymentGateway() throws PaymentException;

	/**
	 * エラー情報取得
	 * @return エラー情報のリスト
	 */
	public List getErrList();

}
