package com.getsecual.shop.payment;

import java.util.ArrayList;
import java.util.List;

import com.gmo_pg.g_pay.client.common.PaymentException;
import com.gmo_pg.g_pay.client.impl.PaymentClientImpl;
import com.gmo_pg.g_pay.client.input.EntryExecTranInput;
import com.gmo_pg.g_pay.client.output.EntryExecTranOutput;

/**
 * ◇カード番号を入力して決済する＜本人認証サービスを未使用＞
 * ◇カード番号を入力して決済する＜本人認証サービスを使用＞
 * ◇登録したカード情報で決済する＜本人認証サービスを未使用＞
 * ◇登録したカード情報で決済する＜本人認証サービスを使用＞
 * @author
 *
 */
public class BankingPaymentGatewayConfiguration extends EntryExecTranInput implements
		PaymentGatewayConfiguration {

	// エラー情報
	private List entryErrList = null;

	/**
	 * 決済実行
	 * @throws com.gmo_pg.g_pay.client.common.PaymentException
	 */
	@Override
	public void executePaymentGateway() throws PaymentException {
		PaymentClientImpl paymentClientImpl = new PaymentClientImpl();

		// 決済実行
		EntryExecTranOutput entryExecTranOutput = paymentClientImpl.doEntryExecTran(this);

		// 結果確認
		if (entryExecTranOutput.isErrorOccurred()) {
			entryErrList = new ArrayList();
			entryErrList.addAll(entryExecTranOutput.getEntryErrList());
			entryErrList.addAll(entryExecTranOutput.getExecErrList());

		}
	}

	// メソッド：executePaymentGatewayの戻り値なしですが、残高不足などのエラーはPaymentExceptionでスローされない為
	// エラーコードとエラー情報の値は一時的に保持するようにしています。
	/**
	 * エラー情報を返却する
	 */
	@Override
	public List getErrList() {
		return this.entryErrList;
	}

}
