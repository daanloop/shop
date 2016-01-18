package com.getsecual.shop.payment;

import java.util.ArrayList;
import java.util.List;

import com.gmo_pg.g_pay.client.common.PaymentException;
import com.gmo_pg.g_pay.client.impl.PaymentClientImpl;
import com.gmo_pg.g_pay.client.input.EntryExecTranInput;
import com.gmo_pg.g_pay.client.output.EntryExecTranOutput;
import com.gmo_pg.g_pay.client.output.SecureTranOutput;

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
	// 3Dセキュア認証結果
	private String paRes = null;
	// 取引ID
	private String md = null;
	// ACS呼出判定
	private String acs;
	// 本人認証パスワード入力画面URL
	private String acsUrl;
	// 本人認証サービス要求電文
	private String paReq;

	/**
	 * 決済実行
	 * @throws com.gmo_pg.g_pay.client.common.PaymentException
	 */
	public void executePaymentGateway() throws PaymentException {
		// GMOPG
		PaymentClientImpl paymentClientImpl = new PaymentClientImpl();

		// 認証後決済(3D セキュア認証結果と取引IDが設定されている場合)
		if (paRes != null && md != null) {
			SecureTranOutput secureTranOutput = paymentClientImpl.doSecureTran(paRes, md);
			// 結果確認
			if (secureTranOutput.isErrorOccurred()) {
				entryErrList = new ArrayList();
				entryErrList.addAll(secureTranOutput.getErrList());
			}
			return;
		}

		// 決済実行
		EntryExecTranOutput entryExecTranOutput = paymentClientImpl.doEntryExecTran(this);

		// 結果確認
		if (entryExecTranOutput.isErrorOccurred()) {
			entryErrList = new ArrayList();
			entryErrList.addAll(entryExecTranOutput.getEntryErrList());
			entryErrList.addAll(entryExecTranOutput.getExecErrList());
		}

		// 3D セキュア認証に必要な値を設定
		this.acs = entryExecTranOutput.getAcs();
		this.acsUrl = entryExecTranOutput.getAcsUrl();
		this.paReq = entryExecTranOutput.getPaReq();
		this.md = entryExecTranOutput.getMd();

	}

	/**
	 * 3D セキュア認証結果を設定
	 */
	public void setPaRes(String paRes) {
		this.paRes = paRes;
	}
	/**
	 * 取引IDを設定
	 */
	public void setMd(String md) {
		this.md = md;
	}

	/**
	 * ACS呼出判定を取得
	 * @return ACS呼出判定
	 */
	public String getAcs() {
		return null;
	}

	/**
	 * 本人認証パスワード入力画面URLを取得
	 * @return 本人認証パスワード入力画面URL
	 */
	public String getAcsUrl() {
		return null;
	}

	/**
	 * 本人認証サービス要求電文を取得
	 * @return 本人認証サービス要求電文
	 */
	public String getPaReq() {
		return null;
	}

	/**
	 * 取引IDを取得
	 * @return 取引ID
	 */
	public String getMd() {
		return null;
	}

	/**
	 * エラー情報を取得
	 * @return エラー情報
	 */
	public List getErrList() {
		return this.entryErrList;
	}


}
