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

	// 取引情報
	public void setShopId(String shopId);					// ショップID
	public void setShopPass(String shopPass);				// ショップパスワード
	public void setOrderId(String orderId);					// オーダーID ショップ発行の取引識別 ID
	public void setJobCd(String jobCd);						// 処理区分
	public void setItemCode(String itemCode);				// 商品コード 省略時はシステム固定値("0000990")
	public void setAmount(Integer amount);					// 利用金額 『有効性チェック』を除く処理区分は必須
	public void setTax(Integer tax);						// 税送料
	public void setTdFlag(String tdFlag);					// セキュア使用フラグ 0:行なわない(デフォルト)
	public void setTdTenantName(String tdTenantName);		// 3D セキュア表示店舗名
	// 決済情報
	public void setAccessId(String accessId);				// 取引ID
	public void setAccessPass(String accessPass);			// 取引パスワード
	public void setMethod(String method);					// 支払方法 ※『有効性チェック』を除く処理区分は必須。
	public void setPayTimes(Integer payTimes);				// 支払回数 ※分割もしくはボーナス分割の支払方法は必須。
	public void setCardNo(String cardNo);					// カード番号
	public void setExpire(String expire);					// 有効期限
	public void setSecurityCode(String securityCode);		// セキュリティーコード
	public void setClientField1(String clientField1);		// 加盟店自由項目 1
	public void setClientField2(String clientField2);		// 加盟店自由項目 2
	public void setClientField3(String clientField3);		// 加盟店自由項目 3
	public void setClientFieldFlag(String clientFieldFlag);	// 加盟店自由項目返却フラグ
	public void setHttpAccept(String httpAccept);			// HTTP_ACCEPT
	public void setHttpUserAgent(String httpUserAgent);		// HTTP_USER_AGENT
	public void setDeviceCategory(String deviceCategory);	// 使用端末情報
	public void setSiteId(String siteId);					// サイトID
	public void setSitePass(String sitePass);				// サイトパスワード
	public void setMemberId(String memberId);				// 会員ID
	public void setSeqMode(String seqMode);					// カード登録連番モード
	public void setCardSeq(Integer cardSeq);				// カード登録連番
	public void setCardPass(String cardPass);				// カードパスワード
	// 3Dセキュア認証後の決済で使用
	public void setPaRes(String paRed);						// 3D セキュア認証結果
	public void setMd(String md);							// 取引ID

	// 決済の処理で失敗して、同じオーダーIDで再度決済を行う場合は必要
	public String getAccessId();							// 取引ID
	public String getAccessPass();							// 取引パスワード
	// 出力値（3D認証に必要な値)
	public String getAcs();									// ACS呼出判定(1:呼出要)
	public String getAcsUrl();								// 本人認証パスワード入力画面URL
	public String getPaReq();								// 本人認証サービス要求電文
	public String getMd();									// 取引ID

	/**
	 * エラー情報取得
	 * @return エラー情報のリスト
	 */
	public List getErrList();

}
