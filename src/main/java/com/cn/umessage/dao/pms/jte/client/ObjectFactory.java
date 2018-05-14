package com.cn.umessage.dao.pms.jte.client;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.datatype.Duration;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;

/**
 * This object contains factory methods for each Java content interface and Java
 * element interface generated in the com.jte.client package.
 * <p>
 * An ObjectFactory allows you to programatically construct new instances of the
 * Java representation for XML content. The Java representation of XML content
 * can consist of schema derived interfaces and classes representing the binding
 * of schema type definitions, element declarations and model groups. Factory
 * methods for each of these are provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

	private final static QName _UnsignedLong_QNAME = new QName(
			"http://schemas.microsoft.com/2003/10/Serialization/",
			"unsignedLong");
	private final static QName _UnsignedByte_QNAME = new QName(
			"http://schemas.microsoft.com/2003/10/Serialization/",
			"unsignedByte");
	private final static QName _UnsignedInt_QNAME = new QName(
			"http://schemas.microsoft.com/2003/10/Serialization/",
			"unsignedInt");
	private final static QName _Char_QNAME = new QName(
			"http://schemas.microsoft.com/2003/10/Serialization/", "char");
	private final static QName _Short_QNAME = new QName(
			"http://schemas.microsoft.com/2003/10/Serialization/", "short");
	private final static QName _Guid_QNAME = new QName(
			"http://schemas.microsoft.com/2003/10/Serialization/", "guid");
	private final static QName _UnsignedShort_QNAME = new QName(
			"http://schemas.microsoft.com/2003/10/Serialization/",
			"unsignedShort");
	private final static QName _Decimal_QNAME = new QName(
			"http://schemas.microsoft.com/2003/10/Serialization/", "decimal");
	private final static QName _Boolean_QNAME = new QName(
			"http://schemas.microsoft.com/2003/10/Serialization/", "boolean");
	private final static QName _Duration_QNAME = new QName(
			"http://schemas.microsoft.com/2003/10/Serialization/", "duration");
	private final static QName _Base64Binary_QNAME = new QName(
			"http://schemas.microsoft.com/2003/10/Serialization/",
			"base64Binary");
	private final static QName _Int_QNAME = new QName(
			"http://schemas.microsoft.com/2003/10/Serialization/", "int");
	private final static QName _Long_QNAME = new QName(
			"http://schemas.microsoft.com/2003/10/Serialization/", "long");
	private final static QName _AnyURI_QNAME = new QName(
			"http://schemas.microsoft.com/2003/10/Serialization/", "anyURI");
	private final static QName _Float_QNAME = new QName(
			"http://schemas.microsoft.com/2003/10/Serialization/", "float");
	private final static QName _DateTime_QNAME = new QName(
			"http://schemas.microsoft.com/2003/10/Serialization/", "dateTime");
	private final static QName _Byte_QNAME = new QName(
			"http://schemas.microsoft.com/2003/10/Serialization/", "byte");
	private final static QName _Double_QNAME = new QName(
			"http://schemas.microsoft.com/2003/10/Serialization/", "double");
	private final static QName _QName_QNAME = new QName(
			"http://schemas.microsoft.com/2003/10/Serialization/", "QName");
	private final static QName _AnyType_QNAME = new QName(
			"http://schemas.microsoft.com/2003/10/Serialization/", "anyType");
	private final static QName _String_QNAME = new QName(
			"http://schemas.microsoft.com/2003/10/Serialization/", "string");
	private final static QName _CancelThirdPartyResponseCancelThirdPartyResult_QNAME = new QName(
			"http://tempuri.org/", "cancelThirdPartyResult");
	private final static QName _CreateGuestMessage_QNAME = new QName(
			"http://tempuri.org/", "message");
	private final static QName _GethHotelcodeHotelname_QNAME = new QName(
			"http://tempuri.org/", "hotelname");
	private final static QName _SetMemberCoustomerNewResponseSetMemberCoustomerNewResult_QNAME = new QName(
			"http://tempuri.org/", "SetMemberCoustomerNewResult");
	private final static QName _PayBookGoldByMemberResponsePayBookGoldByMemberResult_QNAME = new QName(
			"http://tempuri.org/", "payBookGoldByMemberResult");
	private final static QName _SetUnitCollectionResponseSetUnitCollectionResult_QNAME = new QName(
			"http://tempuri.org/", "SetUnitCollectionResult");
	private final static QName _CreateBooksByMoreRoomtypeResponseCreateBooksByMoreRoomtypeResult_QNAME = new QName(
			"http://tempuri.org/", "createBooksByMoreRoomtypeResult");
	private final static QName _ModifyBookByMoreRoomtypeResponseModifyBookByMoreRoomtypeResult_QNAME = new QName(
			"http://tempuri.org/", "modifyBookByMoreRoomtypeResult");
	private final static QName _RefundThirdPartyResponseRefundThirdPartyResult_QNAME = new QName(
			"http://tempuri.org/", "refundThirdPartyResult");
	private final static QName _SendIdentificatioinByCardResponseSendIdentificatioinByCardResult_QNAME = new QName(
			"http://tempuri.org/", "SendIdentificatioinByCardResult");
	private final static QName _SendDesindOutRoomResponseSendDesindOutRoomResult_QNAME = new QName(
			"http://tempuri.org/", "SendDesindOutRoomResult");
	private final static QName _GetRoomTypeResponseGetRoomTypeResult_QNAME = new QName(
			"http://tempuri.org/", "GetRoomTypeResult");
	private final static QName _PayBookGoldByMemberNewResponsePayBookGoldByMemberNewResult_QNAME = new QName(
			"http://tempuri.org/", "payBookGoldByMemberNewResult");
	private final static QName _GetUnitAccountResponseGetUnitAccountResult_QNAME = new QName(
			"http://tempuri.org/", "GetUnitAccountResult");
	private final static QName _GetStateByRoomResponseGetStateByRoomResult_QNAME = new QName(
			"http://tempuri.org/", "GetStateByRoomResult");
	private final static QName _SetUnitMdiAccountsResponseSetUnitMdiAccountsResult_QNAME = new QName(
			"http://tempuri.org/", "SetUnitMdiAccountsResult");
	private final static QName _SendProocessByRoomResponseSendProocessByRoomResult_QNAME = new QName(
			"http://tempuri.org/", "SendProocessByRoomResult");
	private final static QName _SetTogetherByRoomResponseSetTogetherByRoomResult_QNAME = new QName(
			"http://tempuri.org/", "setTogetherByRoomResult");
	private final static QName _SetMediPotolColResponseSetMediPotolColResult_QNAME = new QName(
			"http://tempuri.org/", "SetMediPotolColResult");
	private final static QName _CheckMemberResponseCheckMemberResult_QNAME = new QName(
			"http://tempuri.org/", "checkMemberResult");
	private final static QName _GetMemberResponseGetMemberResult_QNAME = new QName(
			"http://tempuri.org/", "GetMemberResult");
	private final static QName _SetMemberMoneyWechatResponseSetMemberMoneyWechatResult_QNAME = new QName(
			"http://tempuri.org/", "SetMemberMoneyWechatResult");
	private final static QName _ReserveCheckInRoomNewResponseReserveCheckInRoomNewResult_QNAME = new QName(
			"http://tempuri.org/", "reserveCheckInRoomNewResult");
	private final static QName _GetMediPotoColResponseGetMediPotoColResult_QNAME = new QName(
			"http://tempuri.org/", "GetMediPotoColResult");
	private final static QName _GetSpacialPlanpriceCodeResponseGetSpacialPlanpriceCodeResult_QNAME = new QName(
			"http://tempuri.org/", "GetSpacialPlanpriceCodeResult");
	private final static QName _SetGiftResponseSetGiftResult_QNAME = new QName(
			"http://tempuri.org/", "setGiftResult");
	private final static QName _GetZcodePlanPriceCodeHotelcode_QNAME = new QName(
			"http://tempuri.org/", "hotelcode");
	private final static QName _GetRoomPriceByLadderResponseGetRoomPriceByLadderResult_QNAME = new QName(
			"http://tempuri.org/", "GetRoomPriceByLadderResult");
	private final static QName _GetOrderInfoResponseGetOrderInfoResult_QNAME = new QName(
			"http://tempuri.org/", "getOrderInfoResult");
	private final static QName _SetUnitAccountResponseSetUnitAccountResult_QNAME = new QName(
			"http://tempuri.org/", "SetUnitAccountResult");
	private final static QName _PayBookGoldResponsePayBookGoldResult_QNAME = new QName(
			"http://tempuri.org/", "payBookGoldResult");
	private final static QName _QueryUOrderAccResponseQueryUOrderAccResult_QNAME = new QName(
			"http://tempuri.org/", "QueryUOrderAccResult");
	private final static QName _GetRoomPlanPriceSpecialResponseGetRoomPlanPriceSpecialResult_QNAME = new QName(
			"http://tempuri.org/", "GetRoomPlanPriceSpecialResult");
	private final static QName _GetRoomStatusResponseGetRoomStatusResult_QNAME = new QName(
			"http://tempuri.org/", "getRoomStatusResult");
	private final static QName _QueryGuestByInResponseQueryGuestByInResult_QNAME = new QName(
			"http://tempuri.org/", "queryGuestByInResult");
	private final static QName _SetUnitAccountDcmessage_QNAME = new QName(
			"http://tempuri.org/", "dcmessage");
	private final static QName _SetUnitAccountJsmessage_QNAME = new QName(
			"http://tempuri.org/", "jsmessage");
	private final static QName _GetOrderNewResponseGetOrderNewResult_QNAME = new QName(
			"http://tempuri.org/", "GetOrderNewResult");
	private final static QName _GetZcodePlanPriceCodeResponseGetZcodePlanPriceCodeResult_QNAME = new QName(
			"http://tempuri.org/", "GetZcodePlanPriceCodeResult");
	private final static QName _GetHistoryOrderResponseGetHistoryOrderResult_QNAME = new QName(
			"http://tempuri.org/", "GetHistoryOrderResult");
	private final static QName _GetAccountsYueResponseGetAccountsYueResult_QNAME = new QName(
			"http://tempuri.org/", "GetAccountsYueResult");
	private final static QName _CheckInRoomNewResponseCheckInRoomNewResult_QNAME = new QName(
			"http://tempuri.org/", "CheckInRoomNewResult");
	private final static QName _SetExchangeMemberCancelResponseSetExchangeMemberCancelResult_QNAME = new QName(
			"http://tempuri.org/", "SetExchangeMemberCancelResult");
	private final static QName _SetExchangeResponseSetExchangeResult_QNAME = new QName(
			"http://tempuri.org/", "SetExchangeResult");
	private final static QName _GetMemberStoreActiveResponseGetMemberStoreActiveResult_QNAME = new QName(
			"http://tempuri.org/", "GetMemberStoreActiveResult");
	private final static QName _CheckMemberWxResponseCheckMemberWxResult_QNAME = new QName(
			"http://tempuri.org/", "checkMemberWxResult");
	private final static QName _GetRoomStatusNewResponseGetRoomStatusNewResult_QNAME = new QName(
			"http://tempuri.org/", "getRoomStatusNewResult");
	private final static QName _SetaccountsResponseSetaccountsResult_QNAME = new QName(
			"http://tempuri.org/", "SetaccountsResult");
	private final static QName _SetMemberTypeResponseSetMemberTypeResult_QNAME = new QName(
			"http://tempuri.org/", "SetMemberTypeResult");
	private final static QName _GetRoomPriceResponseGetRoomPriceResult_QNAME = new QName(
			"http://tempuri.org/", "GetRoomPriceResult");
	private final static QName _SetReserveroomResponseSetReserveroomResult_QNAME = new QName(
			"http://tempuri.org/", "setReserveroomResult");
	private final static QName _ThirdSetMemberGuestResponseThirdSetMemberGuestResult_QNAME = new QName(
			"http://tempuri.org/", "ThirdSetMemberGuestResult");
	private final static QName _GetstandardResponseGetstandardResult_QNAME = new QName(
			"http://tempuri.org/", "GetstandardResult");
	private final static QName _InsertMemberGuestResponseInsertMemberGuestResult_QNAME = new QName(
			"http://tempuri.org/", "InsertMemberGuestResult");
	private final static QName _UpdateMemberGuestResponseUpdateMemberGuestResult_QNAME = new QName(
			"http://tempuri.org/", "UpdateMemberGuestResult");
	private final static QName _GetRoomPlanByHourResponseGetRoomPlanByHourResult_QNAME = new QName(
			"http://tempuri.org/", "GetRoomPlanByHourResult");
	private final static QName _SetExchangeMemberPasswordResponseSetExchangeMemberPasswordResult_QNAME = new QName(
			"http://tempuri.org/", "SetExchangeMemberPasswordResult");
	private final static QName _GetReserveResponseGetReserveResult_QNAME = new QName(
			"http://tempuri.org/", "GetReserveResult");
	private final static QName _SetExchangeMemberCardNoResponseSetExchangeMemberCardNoResult_QNAME = new QName(
			"http://tempuri.org/", "SetExchangeMemberCardNoResult");
	private final static QName _AgainCheckInroomResponseAgainCheckInroomResult_QNAME = new QName(
			"http://tempuri.org/", "AgainCheckInroomResult");
	private final static QName _SetActiveResponseSetActiveResult_QNAME = new QName(
			"http://tempuri.org/", "SetActiveResult");
	private final static QName _SetMemberCoustomerResponseSetMemberCoustomerResult_QNAME = new QName(
			"http://tempuri.org/", "SetMemberCoustomerResult");
	private final static QName _SendtateByCardResponseSendtateByCardResult_QNAME = new QName(
			"http://tempuri.org/", "SendtateByCardResult");
	private final static QName _GetLeavemessageResponseGetLeavemessageResult_QNAME = new QName(
			"http://tempuri.org/", "GetLeavemessageResult");
	private final static QName _SaveOutByroomResponseSaveOutByroomResult_QNAME = new QName(
			"http://tempuri.org/", "SaveOutByroomResult");
	private final static QName _CancelBookrqResponseCancelBookrqResult_QNAME = new QName(
			"http://tempuri.org/", "CancelBookrqResult");
	private final static QName _GetBottomPriceResponseGetBottomPriceResult_QNAME = new QName(
			"http://tempuri.org/", "getBottomPriceResult");
	private final static QName _GethHotelcodeResponseGethHotelcodeResult_QNAME = new QName(
			"http://tempuri.org/", "GethHotelcodeResult");
	private final static QName _SelectGuestResponseSelectGuestResult_QNAME = new QName(
			"http://tempuri.org/", "selectGuestResult");
	private final static QName _SetUnitPotoColResponseSetUnitPotoColResult_QNAME = new QName(
			"http://tempuri.org/", "SetUnitPotoColResult");
	private final static QName _CreateGuestResponseCreateGuestResult_QNAME = new QName(
			"http://tempuri.org/", "createGuestResult");
	private final static QName _CreateBookrqResponseCreateBookrqResult_QNAME = new QName(
			"http://tempuri.org/", "createBookrqResult");
	private final static QName _SendServiceResponseSendServiceResult_QNAME = new QName(
			"http://tempuri.org/", "sendServiceResult");
	private final static QName _GethHotelcodeNewResponseGethHotelcodeNewResult_QNAME = new QName(
			"http://tempuri.org/", "GethHotelcodeNewResult");
	private final static QName _PayThirdPartyResponsePayThirdPartyResult_QNAME = new QName(
			"http://tempuri.org/", "payThirdPartyResult");
	private final static QName _SetMemberMoneyMoney_QNAME = new QName(
			"http://tempuri.org/", "money");
	private final static QName _GetUnitPotoColResponseGetUnitPotoColResult_QNAME = new QName(
			"http://tempuri.org/", "GetUnitPotoColResult");
	private final static QName _SetRoomStatesResponseSetRoomStatesResult_QNAME = new QName(
			"http://tempuri.org/", "setRoomStatesResult");
	private final static QName _ReserveCheckInRoomResponseReserveCheckInRoomResult_QNAME = new QName(
			"http://tempuri.org/", "reserveCheckInRoomResult");
	private final static QName _CheckInRoomResponseCheckInRoomResult_QNAME = new QName(
			"http://tempuri.org/", "CheckInRoomResult");
	private final static QName _GetOrderResponseGetOrderResult_QNAME = new QName(
			"http://tempuri.org/", "GetOrderResult");
	private final static QName _SetMemberMoneyResponseSetMemberMoneyResult_QNAME = new QName(
			"http://tempuri.org/", "SetMemberMoneyResult");
	private final static QName _GetMemberTypeResponseGetMemberTypeResult_QNAME = new QName(
			"http://tempuri.org/", "GetMemberTypeResult");

	/**
	 * Create a new ObjectFactory that can be used to create new instances of
	 * schema derived classes for package: com.jte.client
	 * 
	 */
	public ObjectFactory() {
	}

	/**
	 * Create an instance of {@link SetUnitPotoCol }
	 * 
	 */
	public SetUnitPotoCol createSetUnitPotoCol() {
		return new SetUnitPotoCol();
	}

	/**
	 * Create an instance of {@link SetActive }
	 * 
	 */
	public SetActive createSetActive() {
		return new SetActive();
	}

	/**
	 * Create an instance of {@link SetExchangeMemberPassword }
	 * 
	 */
	public SetExchangeMemberPassword createSetExchangeMemberPassword() {
		return new SetExchangeMemberPassword();
	}

	/**
	 * Create an instance of {@link SetReserveroomResponse }
	 * 
	 */
	public SetReserveroomResponse createSetReserveroomResponse() {
		return new SetReserveroomResponse();
	}

	/**
	 * Create an instance of {@link PayBookGoldByMemberResponse }
	 * 
	 */
	public PayBookGoldByMemberResponse createPayBookGoldByMemberResponse() {
		return new PayBookGoldByMemberResponse();
	}

	/**
	 * Create an instance of {@link QueryGuestByIn }
	 * 
	 */
	public QueryGuestByIn createQueryGuestByIn() {
		return new QueryGuestByIn();
	}

	/**
	 * Create an instance of {@link AgainCheckInroom }
	 * 
	 */
	public AgainCheckInroom createAgainCheckInroom() {
		return new AgainCheckInroom();
	}

	/**
	 * Create an instance of {@link GetOrderInfoResponse }
	 * 
	 */
	public GetOrderInfoResponse createGetOrderInfoResponse() {
		return new GetOrderInfoResponse();
	}

	/**
	 * Create an instance of {@link SetaccountsResponse }
	 * 
	 */
	public SetaccountsResponse createSetaccountsResponse() {
		return new SetaccountsResponse();
	}

	/**
	 * Create an instance of {@link AgainCheckInroomResponse }
	 * 
	 */
	public AgainCheckInroomResponse createAgainCheckInroomResponse() {
		return new AgainCheckInroomResponse();
	}

	/**
	 * Create an instance of {@link PayBookGoldByMemberNew }
	 * 
	 */
	public PayBookGoldByMemberNew createPayBookGoldByMemberNew() {
		return new PayBookGoldByMemberNew();
	}

	/**
	 * Create an instance of {@link SetExchange }
	 * 
	 */
	public SetExchange createSetExchange() {
		return new SetExchange();
	}

	/**
	 * Create an instance of {@link GetUnitPotoCol }
	 * 
	 */
	public GetUnitPotoCol createGetUnitPotoCol() {
		return new GetUnitPotoCol();
	}

	/**
	 * Create an instance of {@link ReserveCheckInRoomNewResponse }
	 * 
	 */
	public ReserveCheckInRoomNewResponse createReserveCheckInRoomNewResponse() {
		return new ReserveCheckInRoomNewResponse();
	}

	/**
	 * Create an instance of {@link ModifyBookByMoreRoomtypeResponse }
	 * 
	 */
	public ModifyBookByMoreRoomtypeResponse createModifyBookByMoreRoomtypeResponse() {
		return new ModifyBookByMoreRoomtypeResponse();
	}

	/**
	 * Create an instance of {@link GetLeavemessage }
	 * 
	 */
	public GetLeavemessage createGetLeavemessage() {
		return new GetLeavemessage();
	}

	/**
	 * Create an instance of {@link GetRoomPlanPriceSpecialResponse }
	 * 
	 */
	public GetRoomPlanPriceSpecialResponse createGetRoomPlanPriceSpecialResponse() {
		return new GetRoomPlanPriceSpecialResponse();
	}

	/**
	 * Create an instance of {@link GethHotelcodeNew }
	 * 
	 */
	public GethHotelcodeNew createGethHotelcodeNew() {
		return new GethHotelcodeNew();
	}

	/**
	 * Create an instance of {@link GetOrderNew }
	 * 
	 */
	public GetOrderNew createGetOrderNew() {
		return new GetOrderNew();
	}

	/**
	 * Create an instance of {@link GetBottomPrice }
	 * 
	 */
	public GetBottomPrice createGetBottomPrice() {
		return new GetBottomPrice();
	}

	/**
	 * Create an instance of {@link SendIdentificatioinByCard }
	 * 
	 */
	public SendIdentificatioinByCard createSendIdentificatioinByCard() {
		return new SendIdentificatioinByCard();
	}

	/**
	 * Create an instance of {@link SetRoomStates }
	 * 
	 */
	public SetRoomStates createSetRoomStates() {
		return new SetRoomStates();
	}

	/**
	 * Create an instance of {@link SendDesindOutRoomResponse }
	 * 
	 */
	public SendDesindOutRoomResponse createSendDesindOutRoomResponse() {
		return new SendDesindOutRoomResponse();
	}

	/**
	 * Create an instance of {@link SetUnitMdiAccounts }
	 * 
	 */
	public SetUnitMdiAccounts createSetUnitMdiAccounts() {
		return new SetUnitMdiAccounts();
	}

	/**
	 * Create an instance of {@link GethHotelcodeResponse }
	 * 
	 */
	public GethHotelcodeResponse createGethHotelcodeResponse() {
		return new GethHotelcodeResponse();
	}

	/**
	 * Create an instance of {@link GetMemberType }
	 * 
	 */
	public GetMemberType createGetMemberType() {
		return new GetMemberType();
	}

	/**
	 * Create an instance of {@link RefundThirdParty }
	 * 
	 */
	public RefundThirdParty createRefundThirdParty() {
		return new RefundThirdParty();
	}

	/**
	 * Create an instance of {@link GetAccountsYue }
	 * 
	 */
	public GetAccountsYue createGetAccountsYue() {
		return new GetAccountsYue();
	}

	/**
	 * Create an instance of {@link GetRoomStatusNewResponse }
	 * 
	 */
	public GetRoomStatusNewResponse createGetRoomStatusNewResponse() {
		return new GetRoomStatusNewResponse();
	}

	/**
	 * Create an instance of {@link GetBottomPriceResponse }
	 * 
	 */
	public GetBottomPriceResponse createGetBottomPriceResponse() {
		return new GetBottomPriceResponse();
	}

	/**
	 * Create an instance of {@link ReserveCheckInRoomNew }
	 * 
	 */
	public ReserveCheckInRoomNew createReserveCheckInRoomNew() {
		return new ReserveCheckInRoomNew();
	}

	/**
	 * Create an instance of {@link SetUnitCollectionResponse }
	 * 
	 */
	public SetUnitCollectionResponse createSetUnitCollectionResponse() {
		return new SetUnitCollectionResponse();
	}

	/**
	 * Create an instance of {@link SetUnitAccountResponse }
	 * 
	 */
	public SetUnitAccountResponse createSetUnitAccountResponse() {
		return new SetUnitAccountResponse();
	}

	/**
	 * Create an instance of {@link SetMediPotolCol }
	 * 
	 */
	public SetMediPotolCol createSetMediPotolCol() {
		return new SetMediPotolCol();
	}

	/**
	 * Create an instance of {@link SendtateByCard }
	 * 
	 */
	public SendtateByCard createSendtateByCard() {
		return new SendtateByCard();
	}

	/**
	 * Create an instance of {@link CancelThirdPartyResponse }
	 * 
	 */
	public CancelThirdPartyResponse createCancelThirdPartyResponse() {
		return new CancelThirdPartyResponse();
	}

	/**
	 * Create an instance of {@link CheckInRoomResponse }
	 * 
	 */
	public CheckInRoomResponse createCheckInRoomResponse() {
		return new CheckInRoomResponse();
	}

	/**
	 * Create an instance of {@link CancelBookrq }
	 * 
	 */
	public CancelBookrq createCancelBookrq() {
		return new CancelBookrq();
	}

	/**
	 * Create an instance of {@link SetExchangeMemberCancelResponse }
	 * 
	 */
	public SetExchangeMemberCancelResponse createSetExchangeMemberCancelResponse() {
		return new SetExchangeMemberCancelResponse();
	}

	/**
	 * Create an instance of {@link PayBookGold }
	 * 
	 */
	public PayBookGold createPayBookGold() {
		return new PayBookGold();
	}

	/**
	 * Create an instance of {@link GetMember }
	 * 
	 */
	public GetMember createGetMember() {
		return new GetMember();
	}

	/**
	 * Create an instance of {@link GetSpacialPlanpriceCodeResponse }
	 * 
	 */
	public GetSpacialPlanpriceCodeResponse createGetSpacialPlanpriceCodeResponse() {
		return new GetSpacialPlanpriceCodeResponse();
	}

	/**
	 * Create an instance of {@link PayThirdParty }
	 * 
	 */
	public PayThirdParty createPayThirdParty() {
		return new PayThirdParty();
	}

	/**
	 * Create an instance of {@link IsExistsAccounts }
	 * 
	 */
	public IsExistsAccounts createIsExistsAccounts() {
		return new IsExistsAccounts();
	}

	/**
	 * Create an instance of {@link SetExchangeMemberCancel }
	 * 
	 */
	public SetExchangeMemberCancel createSetExchangeMemberCancel() {
		return new SetExchangeMemberCancel();
	}

	/**
	 * Create an instance of {@link GetMemberTypeResponse }
	 * 
	 */
	public GetMemberTypeResponse createGetMemberTypeResponse() {
		return new GetMemberTypeResponse();
	}

	/**
	 * Create an instance of {@link CreateBookrq }
	 * 
	 */
	public CreateBookrq createCreateBookrq() {
		return new CreateBookrq();
	}

	/**
	 * Create an instance of {@link CreateBookrqResponse }
	 * 
	 */
	public CreateBookrqResponse createCreateBookrqResponse() {
		return new CreateBookrqResponse();
	}

	/**
	 * Create an instance of {@link SetExchangeResponse }
	 * 
	 */
	public SetExchangeResponse createSetExchangeResponse() {
		return new SetExchangeResponse();
	}

	/**
	 * Create an instance of {@link GetZcodePlanPriceCodeResponse }
	 * 
	 */
	public GetZcodePlanPriceCodeResponse createGetZcodePlanPriceCodeResponse() {
		return new GetZcodePlanPriceCodeResponse();
	}

	/**
	 * Create an instance of {@link GetstandardResponse }
	 * 
	 */
	public GetstandardResponse createGetstandardResponse() {
		return new GetstandardResponse();
	}

	/**
	 * Create an instance of {@link ThirdSetMemberGuestResponse }
	 * 
	 */
	public ThirdSetMemberGuestResponse createThirdSetMemberGuestResponse() {
		return new ThirdSetMemberGuestResponse();
	}

	/**
	 * Create an instance of {@link SetGiftResponse }
	 * 
	 */
	public SetGiftResponse createSetGiftResponse() {
		return new SetGiftResponse();
	}

	/**
	 * Create an instance of {@link SetMemberCoustomerNew }
	 * 
	 */
	public SetMemberCoustomerNew createSetMemberCoustomerNew() {
		return new SetMemberCoustomerNew();
	}

	/**
	 * Create an instance of {@link CreateBooksByMoreRoomtypeResponse }
	 * 
	 */
	public CreateBooksByMoreRoomtypeResponse createCreateBooksByMoreRoomtypeResponse() {
		return new CreateBooksByMoreRoomtypeResponse();
	}

	/**
	 * Create an instance of {@link SetUnitPotoColResponse }
	 * 
	 */
	public SetUnitPotoColResponse createSetUnitPotoColResponse() {
		return new SetUnitPotoColResponse();
	}

	/**
	 * Create an instance of {@link Getstandard }
	 * 
	 */
	public Getstandard createGetstandard() {
		return new Getstandard();
	}

	/**
	 * Create an instance of {@link PayBookGoldByMember }
	 * 
	 */
	public PayBookGoldByMember createPayBookGoldByMember() {
		return new PayBookGoldByMember();
	}

	/**
	 * Create an instance of {@link InsertMemberGuest }
	 * 
	 */
	public InsertMemberGuest createInsertMemberGuest() {
		return new InsertMemberGuest();
	}

	/**
	 * Create an instance of {@link SetExchangeMemberCardNoResponse }
	 * 
	 */
	public SetExchangeMemberCardNoResponse createSetExchangeMemberCardNoResponse() {
		return new SetExchangeMemberCardNoResponse();
	}

	/**
	 * Create an instance of {@link RefundThirdPartyResponse }
	 * 
	 */
	public RefundThirdPartyResponse createRefundThirdPartyResponse() {
		return new RefundThirdPartyResponse();
	}

	/**
	 * Create an instance of {@link GethHotelcode }
	 * 
	 */
	public GethHotelcode createGethHotelcode() {
		return new GethHotelcode();
	}

	/**
	 * Create an instance of {@link GetRoomPrice }
	 * 
	 */
	public GetRoomPrice createGetRoomPrice() {
		return new GetRoomPrice();
	}

	/**
	 * Create an instance of {@link GetMemberResponse }
	 * 
	 */
	public GetMemberResponse createGetMemberResponse() {
		return new GetMemberResponse();
	}

	/**
	 * Create an instance of {@link SetTogetherByRoomResponse }
	 * 
	 */
	public SetTogetherByRoomResponse createSetTogetherByRoomResponse() {
		return new SetTogetherByRoomResponse();
	}

	/**
	 * Create an instance of {@link SelectGuestResponse }
	 * 
	 */
	public SelectGuestResponse createSelectGuestResponse() {
		return new SelectGuestResponse();
	}

	/**
	 * Create an instance of {@link SetMemberCoustomerResponse }
	 * 
	 */
	public SetMemberCoustomerResponse createSetMemberCoustomerResponse() {
		return new SetMemberCoustomerResponse();
	}

	/**
	 * Create an instance of {@link PayBookGoldResponse }
	 * 
	 */
	public PayBookGoldResponse createPayBookGoldResponse() {
		return new PayBookGoldResponse();
	}

	/**
	 * Create an instance of {@link SetMemberCoustomerNewResponse }
	 * 
	 */
	public SetMemberCoustomerNewResponse createSetMemberCoustomerNewResponse() {
		return new SetMemberCoustomerNewResponse();
	}

	/**
	 * Create an instance of {@link CheckInRoom }
	 * 
	 */
	public CheckInRoom createCheckInRoom() {
		return new CheckInRoom();
	}

	/**
	 * Create an instance of {@link GetOrderResponse }
	 * 
	 */
	public GetOrderResponse createGetOrderResponse() {
		return new GetOrderResponse();
	}

	/**
	 * Create an instance of {@link GetOrder }
	 * 
	 */
	public GetOrder createGetOrder() {
		return new GetOrder();
	}

	/**
	 * Create an instance of {@link SetRoomStatesResponse }
	 * 
	 */
	public SetRoomStatesResponse createSetRoomStatesResponse() {
		return new SetRoomStatesResponse();
	}

	/**
	 * Create an instance of {@link QueryUOrderAccResponse }
	 * 
	 */
	public QueryUOrderAccResponse createQueryUOrderAccResponse() {
		return new QueryUOrderAccResponse();
	}

	/**
	 * Create an instance of {@link CheckMemberWx }
	 * 
	 */
	public CheckMemberWx createCheckMemberWx() {
		return new CheckMemberWx();
	}

	/**
	 * Create an instance of {@link ReserveCheckInRoom }
	 * 
	 */
	public ReserveCheckInRoom createReserveCheckInRoom() {
		return new ReserveCheckInRoom();
	}

	/**
	 * Create an instance of {@link GetMemberStoreActive }
	 * 
	 */
	public GetMemberStoreActive createGetMemberStoreActive() {
		return new GetMemberStoreActive();
	}

	/**
	 * Create an instance of {@link GetOrderInfo }
	 * 
	 */
	public GetOrderInfo createGetOrderInfo() {
		return new GetOrderInfo();
	}

	/**
	 * Create an instance of {@link SendProocessByRoomResponse }
	 * 
	 */
	public SendProocessByRoomResponse createSendProocessByRoomResponse() {
		return new SendProocessByRoomResponse();
	}

	/**
	 * Create an instance of {@link PayBookGoldByMemberNewResponse }
	 * 
	 */
	public PayBookGoldByMemberNewResponse createPayBookGoldByMemberNewResponse() {
		return new PayBookGoldByMemberNewResponse();
	}

	/**
	 * Create an instance of {@link SendtateByCardResponse }
	 * 
	 */
	public SendtateByCardResponse createSendtateByCardResponse() {
		return new SendtateByCardResponse();
	}

	/**
	 * Create an instance of {@link CreateGuest }
	 * 
	 */
	public CreateGuest createCreateGuest() {
		return new CreateGuest();
	}

	/**
	 * Create an instance of {@link CheckMember }
	 * 
	 */
	public CheckMember createCheckMember() {
		return new CheckMember();
	}

	/**
	 * Create an instance of {@link GetUnitPotoColResponse }
	 * 
	 */
	public GetUnitPotoColResponse createGetUnitPotoColResponse() {
		return new GetUnitPotoColResponse();
	}

	/**
	 * Create an instance of {@link SendService }
	 * 
	 */
	public SendService createSendService() {
		return new SendService();
	}

	/**
	 * Create an instance of {@link SaveOutByroom }
	 * 
	 */
	public SaveOutByroom createSaveOutByroom() {
		return new SaveOutByroom();
	}

	/**
	 * Create an instance of {@link GetAccountsYueResponse }
	 * 
	 */
	public GetAccountsYueResponse createGetAccountsYueResponse() {
		return new GetAccountsYueResponse();
	}

	/**
	 * Create an instance of {@link QueryGuestByInResponse }
	 * 
	 */
	public QueryGuestByInResponse createQueryGuestByInResponse() {
		return new QueryGuestByInResponse();
	}

	/**
	 * Create an instance of {@link CreateBooksByMoreRoomtype }
	 * 
	 */
	public CreateBooksByMoreRoomtype createCreateBooksByMoreRoomtype() {
		return new CreateBooksByMoreRoomtype();
	}

	/**
	 * Create an instance of {@link SaveOutByroomResponse }
	 * 
	 */
	public SaveOutByroomResponse createSaveOutByroomResponse() {
		return new SaveOutByroomResponse();
	}

	/**
	 * Create an instance of {@link Setaccounts }
	 * 
	 */
	public Setaccounts createSetaccounts() {
		return new Setaccounts();
	}

	/**
	 * Create an instance of {@link GetReserveResponse }
	 * 
	 */
	public GetReserveResponse createGetReserveResponse() {
		return new GetReserveResponse();
	}

	/**
	 * Create an instance of {@link UpdateMemberGuestResponse }
	 * 
	 */
	public UpdateMemberGuestResponse createUpdateMemberGuestResponse() {
		return new UpdateMemberGuestResponse();
	}

	/**
	 * Create an instance of {@link SetMemberMoneyWechat }
	 * 
	 */
	public SetMemberMoneyWechat createSetMemberMoneyWechat() {
		return new SetMemberMoneyWechat();
	}

	/**
	 * Create an instance of {@link SetReserveroom }
	 * 
	 */
	public SetReserveroom createSetReserveroom() {
		return new SetReserveroom();
	}

	/**
	 * Create an instance of {@link GetMemberStoreActiveResponse }
	 * 
	 */
	public GetMemberStoreActiveResponse createGetMemberStoreActiveResponse() {
		return new GetMemberStoreActiveResponse();
	}

	/**
	 * Create an instance of {@link SetMemberCoustomer }
	 * 
	 */
	public SetMemberCoustomer createSetMemberCoustomer() {
		return new SetMemberCoustomer();
	}

	/**
	 * Create an instance of {@link SetMemberTypeResponse }
	 * 
	 */
	public SetMemberTypeResponse createSetMemberTypeResponse() {
		return new SetMemberTypeResponse();
	}

	/**
	 * Create an instance of {@link GetUnitAccount }
	 * 
	 */
	public GetUnitAccount createGetUnitAccount() {
		return new GetUnitAccount();
	}

	/**
	 * Create an instance of {@link SetMemberMoney }
	 * 
	 */
	public SetMemberMoney createSetMemberMoney() {
		return new SetMemberMoney();
	}

	/**
	 * Create an instance of {@link SetUnitCollection }
	 * 
	 */
	public SetUnitCollection createSetUnitCollection() {
		return new SetUnitCollection();
	}

	/**
	 * Create an instance of {@link GetReserve }
	 * 
	 */
	public GetReserve createGetReserve() {
		return new GetReserve();
	}

	/**
	 * Create an instance of {@link SetMemberMoneyWechatResponse }
	 * 
	 */
	public SetMemberMoneyWechatResponse createSetMemberMoneyWechatResponse() {
		return new SetMemberMoneyWechatResponse();
	}

	/**
	 * Create an instance of {@link GetRoomPlanByHour }
	 * 
	 */
	public GetRoomPlanByHour createGetRoomPlanByHour() {
		return new GetRoomPlanByHour();
	}

	/**
	 * Create an instance of {@link InsertMemberGuestResponse }
	 * 
	 */
	public InsertMemberGuestResponse createInsertMemberGuestResponse() {
		return new InsertMemberGuestResponse();
	}

	/**
	 * Create an instance of {@link SendProocessByRoom }
	 * 
	 */
	public SendProocessByRoom createSendProocessByRoom() {
		return new SendProocessByRoom();
	}

	/**
	 * Create an instance of {@link GethHotelcodeNewResponse }
	 * 
	 */
	public GethHotelcodeNewResponse createGethHotelcodeNewResponse() {
		return new GethHotelcodeNewResponse();
	}

	/**
	 * Create an instance of {@link GetRoomPlanPriceSpecial }
	 * 
	 */
	public GetRoomPlanPriceSpecial createGetRoomPlanPriceSpecial() {
		return new GetRoomPlanPriceSpecial();
	}

	/**
	 * Create an instance of {@link GetRoomPriceByLadderResponse }
	 * 
	 */
	public GetRoomPriceByLadderResponse createGetRoomPriceByLadderResponse() {
		return new GetRoomPriceByLadderResponse();
	}

	/**
	 * Create an instance of {@link GetLeavemessageResponse }
	 * 
	 */
	public GetLeavemessageResponse createGetLeavemessageResponse() {
		return new GetLeavemessageResponse();
	}

	/**
	 * Create an instance of {@link UpdateMemberGuest }
	 * 
	 */
	public UpdateMemberGuest createUpdateMemberGuest() {
		return new UpdateMemberGuest();
	}

	/**
	 * Create an instance of {@link SetExchangeMemberCardNo }
	 * 
	 */
	public SetExchangeMemberCardNo createSetExchangeMemberCardNo() {
		return new SetExchangeMemberCardNo();
	}

	/**
	 * Create an instance of {@link GetRoomStatusResponse }
	 * 
	 */
	public GetRoomStatusResponse createGetRoomStatusResponse() {
		return new GetRoomStatusResponse();
	}

	/**
	 * Create an instance of {@link GetHistoryOrderResponse }
	 * 
	 */
	public GetHistoryOrderResponse createGetHistoryOrderResponse() {
		return new GetHistoryOrderResponse();
	}

	/**
	 * Create an instance of {@link SelectGuest }
	 * 
	 */
	public SelectGuest createSelectGuest() {
		return new SelectGuest();
	}

	/**
	 * Create an instance of {@link GetRoomPriceResponse }
	 * 
	 */
	public GetRoomPriceResponse createGetRoomPriceResponse() {
		return new GetRoomPriceResponse();
	}

	/**
	 * Create an instance of {@link CheckMemberWxResponse }
	 * 
	 */
	public CheckMemberWxResponse createCheckMemberWxResponse() {
		return new CheckMemberWxResponse();
	}

	/**
	 * Create an instance of {@link GetRoomTypeResponse }
	 * 
	 */
	public GetRoomTypeResponse createGetRoomTypeResponse() {
		return new GetRoomTypeResponse();
	}

	/**
	 * Create an instance of {@link SetExchangeMemberPasswordResponse }
	 * 
	 */
	public SetExchangeMemberPasswordResponse createSetExchangeMemberPasswordResponse() {
		return new SetExchangeMemberPasswordResponse();
	}

	/**
	 * Create an instance of {@link SetMemberType }
	 * 
	 */
	public SetMemberType createSetMemberType() {
		return new SetMemberType();
	}

	/**
	 * Create an instance of {@link CheckMemberResponse }
	 * 
	 */
	public CheckMemberResponse createCheckMemberResponse() {
		return new CheckMemberResponse();
	}

	/**
	 * Create an instance of {@link GetRoomStatusNew }
	 * 
	 */
	public GetRoomStatusNew createGetRoomStatusNew() {
		return new GetRoomStatusNew();
	}

	/**
	 * Create an instance of {@link SendIdentificatioinByCardResponse }
	 * 
	 */
	public SendIdentificatioinByCardResponse createSendIdentificatioinByCardResponse() {
		return new SendIdentificatioinByCardResponse();
	}

	/**
	 * Create an instance of {@link CancelThirdParty }
	 * 
	 */
	public CancelThirdParty createCancelThirdParty() {
		return new CancelThirdParty();
	}

	/**
	 * Create an instance of {@link GetOrderNewResponse }
	 * 
	 */
	public GetOrderNewResponse createGetOrderNewResponse() {
		return new GetOrderNewResponse();
	}

	/**
	 * Create an instance of {@link GetMediPotoColResponse }
	 * 
	 */
	public GetMediPotoColResponse createGetMediPotoColResponse() {
		return new GetMediPotoColResponse();
	}

	/**
	 * Create an instance of {@link GetStateByRoomResponse }
	 * 
	 */
	public GetStateByRoomResponse createGetStateByRoomResponse() {
		return new GetStateByRoomResponse();
	}

	/**
	 * Create an instance of {@link GetRoomPlanByHourResponse }
	 * 
	 */
	public GetRoomPlanByHourResponse createGetRoomPlanByHourResponse() {
		return new GetRoomPlanByHourResponse();
	}

	/**
	 * Create an instance of {@link GetRoomPriceByLadder }
	 * 
	 */
	public GetRoomPriceByLadder createGetRoomPriceByLadder() {
		return new GetRoomPriceByLadder();
	}

	/**
	 * Create an instance of {@link SendDesindOutRoom }
	 * 
	 */
	public SendDesindOutRoom createSendDesindOutRoom() {
		return new SendDesindOutRoom();
	}

	/**
	 * Create an instance of {@link GetSpacialPlanpriceCode }
	 * 
	 */
	public GetSpacialPlanpriceCode createGetSpacialPlanpriceCode() {
		return new GetSpacialPlanpriceCode();
	}

	/**
	 * Create an instance of {@link SendServiceResponse }
	 * 
	 */
	public SendServiceResponse createSendServiceResponse() {
		return new SendServiceResponse();
	}

	/**
	 * Create an instance of {@link SetUnitAccount }
	 * 
	 */
	public SetUnitAccount createSetUnitAccount() {
		return new SetUnitAccount();
	}

	/**
	 * Create an instance of {@link SetTogetherByRoom }
	 * 
	 */
	public SetTogetherByRoom createSetTogetherByRoom() {
		return new SetTogetherByRoom();
	}

	/**
	 * Create an instance of {@link GetRoomStatus }
	 * 
	 */
	public GetRoomStatus createGetRoomStatus() {
		return new GetRoomStatus();
	}

	/**
	 * Create an instance of {@link CheckInRoomNewResponse }
	 * 
	 */
	public CheckInRoomNewResponse createCheckInRoomNewResponse() {
		return new CheckInRoomNewResponse();
	}

	/**
	 * Create an instance of {@link GetHistoryOrder }
	 * 
	 */
	public GetHistoryOrder createGetHistoryOrder() {
		return new GetHistoryOrder();
	}

	/**
	 * Create an instance of {@link GetRoomType }
	 * 
	 */
	public GetRoomType createGetRoomType() {
		return new GetRoomType();
	}

	/**
	 * Create an instance of {@link CheckInRoomNew }
	 * 
	 */
	public CheckInRoomNew createCheckInRoomNew() {
		return new CheckInRoomNew();
	}

	/**
	 * Create an instance of {@link ReserveCheckInRoomResponse }
	 * 
	 */
	public ReserveCheckInRoomResponse createReserveCheckInRoomResponse() {
		return new ReserveCheckInRoomResponse();
	}

	/**
	 * Create an instance of {@link GetZcodePlanPriceCode }
	 * 
	 */
	public GetZcodePlanPriceCode createGetZcodePlanPriceCode() {
		return new GetZcodePlanPriceCode();
	}

	/**
	 * Create an instance of {@link SetMemberMoneyResponse }
	 * 
	 */
	public SetMemberMoneyResponse createSetMemberMoneyResponse() {
		return new SetMemberMoneyResponse();
	}

	/**
	 * Create an instance of {@link GetStateByRoom }
	 * 
	 */
	public GetStateByRoom createGetStateByRoom() {
		return new GetStateByRoom();
	}

	/**
	 * Create an instance of {@link ThirdSetMemberGuest }
	 * 
	 */
	public ThirdSetMemberGuest createThirdSetMemberGuest() {
		return new ThirdSetMemberGuest();
	}

	/**
	 * Create an instance of {@link GetMediPotoCol }
	 * 
	 */
	public GetMediPotoCol createGetMediPotoCol() {
		return new GetMediPotoCol();
	}

	/**
	 * Create an instance of {@link GetUnitAccountResponse }
	 * 
	 */
	public GetUnitAccountResponse createGetUnitAccountResponse() {
		return new GetUnitAccountResponse();
	}

	/**
	 * Create an instance of {@link PayThirdPartyResponse }
	 * 
	 */
	public PayThirdPartyResponse createPayThirdPartyResponse() {
		return new PayThirdPartyResponse();
	}

	/**
	 * Create an instance of {@link SetActiveResponse }
	 * 
	 */
	public SetActiveResponse createSetActiveResponse() {
		return new SetActiveResponse();
	}

	/**
	 * Create an instance of {@link QueryUOrderAcc }
	 * 
	 */
	public QueryUOrderAcc createQueryUOrderAcc() {
		return new QueryUOrderAcc();
	}

	/**
	 * Create an instance of {@link SetUnitMdiAccountsResponse }
	 * 
	 */
	public SetUnitMdiAccountsResponse createSetUnitMdiAccountsResponse() {
		return new SetUnitMdiAccountsResponse();
	}

	/**
	 * Create an instance of {@link SetGift }
	 * 
	 */
	public SetGift createSetGift() {
		return new SetGift();
	}

	/**
	 * Create an instance of {@link CreateGuestResponse }
	 * 
	 */
	public CreateGuestResponse createCreateGuestResponse() {
		return new CreateGuestResponse();
	}

	/**
	 * Create an instance of {@link ModifyBookByMoreRoomtype }
	 * 
	 */
	public ModifyBookByMoreRoomtype createModifyBookByMoreRoomtype() {
		return new ModifyBookByMoreRoomtype();
	}

	/**
	 * Create an instance of {@link IsExistsAccountsResponse }
	 * 
	 */
	public IsExistsAccountsResponse createIsExistsAccountsResponse() {
		return new IsExistsAccountsResponse();
	}

	/**
	 * Create an instance of {@link CancelBookrqResponse }
	 * 
	 */
	public CancelBookrqResponse createCancelBookrqResponse() {
		return new CancelBookrqResponse();
	}

	/**
	 * Create an instance of {@link SetMediPotolColResponse }
	 * 
	 */
	public SetMediPotolColResponse createSetMediPotolColResponse() {
		return new SetMediPotolColResponse();
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }
	 * {@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "unsignedLong")
	public JAXBElement<BigInteger> createUnsignedLong(BigInteger value) {
		return new JAXBElement<BigInteger>(_UnsignedLong_QNAME,
				BigInteger.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link Short }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "unsignedByte")
	public JAXBElement<Short> createUnsignedByte(Short value) {
		return new JAXBElement<Short>(_UnsignedByte_QNAME, Short.class, null,
				value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "unsignedInt")
	public JAXBElement<Long> createUnsignedInt(Long value) {
		return new JAXBElement<Long>(_UnsignedInt_QNAME, Long.class, null,
				value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "char")
	public JAXBElement<Integer> createChar(Integer value) {
		return new JAXBElement<Integer>(_Char_QNAME, Integer.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link Short }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "short")
	public JAXBElement<Short> createShort(Short value) {
		return new JAXBElement<Short>(_Short_QNAME, Short.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "guid")
	public JAXBElement<String> createGuid(String value) {
		return new JAXBElement<String>(_Guid_QNAME, String.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "unsignedShort")
	public JAXBElement<Integer> createUnsignedShort(Integer value) {
		return new JAXBElement<Integer>(_UnsignedShort_QNAME, Integer.class,
				null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }
	 * {@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "decimal")
	public JAXBElement<BigDecimal> createDecimal(BigDecimal value) {
		return new JAXBElement<BigDecimal>(_Decimal_QNAME, BigDecimal.class,
				null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "boolean")
	public JAXBElement<Boolean> createBoolean(Boolean value) {
		return new JAXBElement<Boolean>(_Boolean_QNAME, Boolean.class, null,
				value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link Duration }
	 * {@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "duration")
	public JAXBElement<Duration> createDuration(Duration value) {
		return new JAXBElement<Duration>(_Duration_QNAME, Duration.class, null,
				value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "base64Binary")
	public JAXBElement<byte[]> createBase64Binary(byte[] value) {
		return new JAXBElement<byte[]>(_Base64Binary_QNAME, byte[].class, null,
				((byte[]) value));
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "int")
	public JAXBElement<Integer> createInt(Integer value) {
		return new JAXBElement<Integer>(_Int_QNAME, Integer.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "long")
	public JAXBElement<Long> createLong(Long value) {
		return new JAXBElement<Long>(_Long_QNAME, Long.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "anyURI")
	public JAXBElement<String> createAnyURI(String value) {
		return new JAXBElement<String>(_AnyURI_QNAME, String.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link Float }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "float")
	public JAXBElement<Float> createFloat(Float value) {
		return new JAXBElement<Float>(_Float_QNAME, Float.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link XMLGregorianCalendar }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "dateTime")
	public JAXBElement<XMLGregorianCalendar> createDateTime(
			XMLGregorianCalendar value) {
		return new JAXBElement<XMLGregorianCalendar>(_DateTime_QNAME,
				XMLGregorianCalendar.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link Byte }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "byte")
	public JAXBElement<Byte> createByte(Byte value) {
		return new JAXBElement<Byte>(_Byte_QNAME, Byte.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link Double }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "double")
	public JAXBElement<Double> createDouble(Double value) {
		return new JAXBElement<Double>(_Double_QNAME, Double.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link QName }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "QName")
	public JAXBElement<QName> createQName(QName value) {
		return new JAXBElement<QName>(_QName_QNAME, QName.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "anyType")
	public JAXBElement<Object> createAnyType(Object value) {
		return new JAXBElement<Object>(_AnyType_QNAME, Object.class, null,
				value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "string")
	public JAXBElement<String> createString(String value) {
		return new JAXBElement<String>(_String_QNAME, String.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "cancelThirdPartyResult", scope = CancelThirdPartyResponse.class)
	public JAXBElement<String> createCancelThirdPartyResponseCancelThirdPartyResult(
			String value) {
		return new JAXBElement<String>(
				_CancelThirdPartyResponseCancelThirdPartyResult_QNAME,
				String.class, CancelThirdPartyResponse.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "message", scope = CreateGuest.class)
	public JAXBElement<String> createCreateGuestMessage(String value) {
		return new JAXBElement<String>(_CreateGuestMessage_QNAME, String.class,
				CreateGuest.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "hotelname", scope = GethHotelcode.class)
	public JAXBElement<String> createGethHotelcodeHotelname(String value) {
		return new JAXBElement<String>(_GethHotelcodeHotelname_QNAME,
				String.class, GethHotelcode.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "SetMemberCoustomerNewResult", scope = SetMemberCoustomerNewResponse.class)
	public JAXBElement<String> createSetMemberCoustomerNewResponseSetMemberCoustomerNewResult(
			String value) {
		return new JAXBElement<String>(
				_SetMemberCoustomerNewResponseSetMemberCoustomerNewResult_QNAME,
				String.class, SetMemberCoustomerNewResponse.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "payBookGoldByMemberResult", scope = PayBookGoldByMemberResponse.class)
	public JAXBElement<String> createPayBookGoldByMemberResponsePayBookGoldByMemberResult(
			String value) {
		return new JAXBElement<String>(
				_PayBookGoldByMemberResponsePayBookGoldByMemberResult_QNAME,
				String.class, PayBookGoldByMemberResponse.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "SetUnitCollectionResult", scope = SetUnitCollectionResponse.class)
	public JAXBElement<String> createSetUnitCollectionResponseSetUnitCollectionResult(
			String value) {
		return new JAXBElement<String>(
				_SetUnitCollectionResponseSetUnitCollectionResult_QNAME,
				String.class, SetUnitCollectionResponse.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "message", scope = CreateBookrq.class)
	public JAXBElement<String> createCreateBookrqMessage(String value) {
		return new JAXBElement<String>(_CreateGuestMessage_QNAME, String.class,
				CreateBookrq.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "createBooksByMoreRoomtypeResult", scope = CreateBooksByMoreRoomtypeResponse.class)
	public JAXBElement<String> createCreateBooksByMoreRoomtypeResponseCreateBooksByMoreRoomtypeResult(
			String value) {
		return new JAXBElement<String>(
				_CreateBooksByMoreRoomtypeResponseCreateBooksByMoreRoomtypeResult_QNAME,
				String.class, CreateBooksByMoreRoomtypeResponse.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "message", scope = SetExchangeMemberCardNo.class)
	public JAXBElement<String> createSetExchangeMemberCardNoMessage(String value) {
		return new JAXBElement<String>(_CreateGuestMessage_QNAME, String.class,
				SetExchangeMemberCardNo.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "modifyBookByMoreRoomtypeResult", scope = ModifyBookByMoreRoomtypeResponse.class)
	public JAXBElement<String> createModifyBookByMoreRoomtypeResponseModifyBookByMoreRoomtypeResult(
			String value) {
		return new JAXBElement<String>(
				_ModifyBookByMoreRoomtypeResponseModifyBookByMoreRoomtypeResult_QNAME,
				String.class, ModifyBookByMoreRoomtypeResponse.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "refundThirdPartyResult", scope = RefundThirdPartyResponse.class)
	public JAXBElement<String> createRefundThirdPartyResponseRefundThirdPartyResult(
			String value) {
		return new JAXBElement<String>(
				_RefundThirdPartyResponseRefundThirdPartyResult_QNAME,
				String.class, RefundThirdPartyResponse.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "SendIdentificatioinByCardResult", scope = SendIdentificatioinByCardResponse.class)
	public JAXBElement<String> createSendIdentificatioinByCardResponseSendIdentificatioinByCardResult(
			String value) {
		return new JAXBElement<String>(
				_SendIdentificatioinByCardResponseSendIdentificatioinByCardResult_QNAME,
				String.class, SendIdentificatioinByCardResponse.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "SendDesindOutRoomResult", scope = SendDesindOutRoomResponse.class)
	public JAXBElement<String> createSendDesindOutRoomResponseSendDesindOutRoomResult(
			String value) {
		return new JAXBElement<String>(
				_SendDesindOutRoomResponseSendDesindOutRoomResult_QNAME,
				String.class, SendDesindOutRoomResponse.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "message", scope = SendtateByCard.class)
	public JAXBElement<String> createSendtateByCardMessage(String value) {
		return new JAXBElement<String>(_CreateGuestMessage_QNAME, String.class,
				SendtateByCard.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "message", scope = SetGift.class)
	public JAXBElement<String> createSetGiftMessage(String value) {
		return new JAXBElement<String>(_CreateGuestMessage_QNAME, String.class,
				SetGift.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "GetRoomTypeResult", scope = GetRoomTypeResponse.class)
	public JAXBElement<String> createGetRoomTypeResponseGetRoomTypeResult(
			String value) {
		return new JAXBElement<String>(
				_GetRoomTypeResponseGetRoomTypeResult_QNAME, String.class,
				GetRoomTypeResponse.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "message", scope = GetUnitAccount.class)
	public JAXBElement<String> createGetUnitAccountMessage(String value) {
		return new JAXBElement<String>(_CreateGuestMessage_QNAME, String.class,
				GetUnitAccount.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "message", scope = GetUnitPotoCol.class)
	public JAXBElement<String> createGetUnitPotoColMessage(String value) {
		return new JAXBElement<String>(_CreateGuestMessage_QNAME, String.class,
				GetUnitPotoCol.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "payBookGoldByMemberNewResult", scope = PayBookGoldByMemberNewResponse.class)
	public JAXBElement<String> createPayBookGoldByMemberNewResponsePayBookGoldByMemberNewResult(
			String value) {
		return new JAXBElement<String>(
				_PayBookGoldByMemberNewResponsePayBookGoldByMemberNewResult_QNAME,
				String.class, PayBookGoldByMemberNewResponse.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "message", scope = SetReserveroom.class)
	public JAXBElement<String> createSetReserveroomMessage(String value) {
		return new JAXBElement<String>(_CreateGuestMessage_QNAME, String.class,
				SetReserveroom.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "GetUnitAccountResult", scope = GetUnitAccountResponse.class)
	public JAXBElement<String> createGetUnitAccountResponseGetUnitAccountResult(
			String value) {
		return new JAXBElement<String>(
				_GetUnitAccountResponseGetUnitAccountResult_QNAME,
				String.class, GetUnitAccountResponse.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "message", scope = SetExchange.class)
	public JAXBElement<String> createSetExchangeMessage(String value) {
		return new JAXBElement<String>(_CreateGuestMessage_QNAME, String.class,
				SetExchange.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "message", scope = SendIdentificatioinByCard.class)
	public JAXBElement<String> createSendIdentificatioinByCardMessage(
			String value) {
		return new JAXBElement<String>(_CreateGuestMessage_QNAME, String.class,
				SendIdentificatioinByCard.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "GetStateByRoomResult", scope = GetStateByRoomResponse.class)
	public JAXBElement<String> createGetStateByRoomResponseGetStateByRoomResult(
			String value) {
		return new JAXBElement<String>(
				_GetStateByRoomResponseGetStateByRoomResult_QNAME,
				String.class, GetStateByRoomResponse.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "SetUnitMdiAccountsResult", scope = SetUnitMdiAccountsResponse.class)
	public JAXBElement<String> createSetUnitMdiAccountsResponseSetUnitMdiAccountsResult(
			String value) {
		return new JAXBElement<String>(
				_SetUnitMdiAccountsResponseSetUnitMdiAccountsResult_QNAME,
				String.class, SetUnitMdiAccountsResponse.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "message", scope = CreateBooksByMoreRoomtype.class)
	public JAXBElement<String> createCreateBooksByMoreRoomtypeMessage(
			String value) {
		return new JAXBElement<String>(_CreateGuestMessage_QNAME, String.class,
				CreateBooksByMoreRoomtype.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "SendProocessByRoomResult", scope = SendProocessByRoomResponse.class)
	public JAXBElement<String> createSendProocessByRoomResponseSendProocessByRoomResult(
			String value) {
		return new JAXBElement<String>(
				_SendProocessByRoomResponseSendProocessByRoomResult_QNAME,
				String.class, SendProocessByRoomResponse.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "setTogetherByRoomResult", scope = SetTogetherByRoomResponse.class)
	public JAXBElement<String> createSetTogetherByRoomResponseSetTogetherByRoomResult(
			String value) {
		return new JAXBElement<String>(
				_SetTogetherByRoomResponseSetTogetherByRoomResult_QNAME,
				String.class, SetTogetherByRoomResponse.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "message", scope = GetRoomStatusNew.class)
	public JAXBElement<String> createGetRoomStatusNewMessage(String value) {
		return new JAXBElement<String>(_CreateGuestMessage_QNAME, String.class,
				GetRoomStatusNew.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "SetMediPotolColResult", scope = SetMediPotolColResponse.class)
	public JAXBElement<String> createSetMediPotolColResponseSetMediPotolColResult(
			String value) {
		return new JAXBElement<String>(
				_SetMediPotolColResponseSetMediPotolColResult_QNAME,
				String.class, SetMediPotolColResponse.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "message", scope = GetOrderInfo.class)
	public JAXBElement<String> createGetOrderInfoMessage(String value) {
		return new JAXBElement<String>(_CreateGuestMessage_QNAME, String.class,
				GetOrderInfo.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "checkMemberResult", scope = CheckMemberResponse.class)
	public JAXBElement<String> createCheckMemberResponseCheckMemberResult(
			String value) {
		return new JAXBElement<String>(
				_CheckMemberResponseCheckMemberResult_QNAME, String.class,
				CheckMemberResponse.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "message", scope = SendDesindOutRoom.class)
	public JAXBElement<String> createSendDesindOutRoomMessage(String value) {
		return new JAXBElement<String>(_CreateGuestMessage_QNAME, String.class,
				SendDesindOutRoom.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "message", scope = GetOrderNew.class)
	public JAXBElement<String> createGetOrderNewMessage(String value) {
		return new JAXBElement<String>(_CreateGuestMessage_QNAME, String.class,
				GetOrderNew.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "message", scope = SetUnitCollection.class)
	public JAXBElement<String> createSetUnitCollectionMessage(String value) {
		return new JAXBElement<String>(_CreateGuestMessage_QNAME, String.class,
				SetUnitCollection.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "hotelname", scope = GethHotelcodeNew.class)
	public JAXBElement<String> createGethHotelcodeNewHotelname(String value) {
		return new JAXBElement<String>(_GethHotelcodeHotelname_QNAME,
				String.class, GethHotelcodeNew.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "message", scope = ModifyBookByMoreRoomtype.class)
	public JAXBElement<String> createModifyBookByMoreRoomtypeMessage(
			String value) {
		return new JAXBElement<String>(_CreateGuestMessage_QNAME, String.class,
				ModifyBookByMoreRoomtype.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "message", scope = ReserveCheckInRoom.class)
	public JAXBElement<String> createReserveCheckInRoomMessage(String value) {
		return new JAXBElement<String>(_CreateGuestMessage_QNAME, String.class,
				ReserveCheckInRoom.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "message", scope = GetMember.class)
	public JAXBElement<String> createGetMemberMessage(String value) {
		return new JAXBElement<String>(_CreateGuestMessage_QNAME, String.class,
				GetMember.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "GetMemberResult", scope = GetMemberResponse.class)
	public JAXBElement<String> createGetMemberResponseGetMemberResult(
			String value) {
		return new JAXBElement<String>(_GetMemberResponseGetMemberResult_QNAME,
				String.class, GetMemberResponse.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "SetMemberMoneyWechatResult", scope = SetMemberMoneyWechatResponse.class)
	public JAXBElement<String> createSetMemberMoneyWechatResponseSetMemberMoneyWechatResult(
			String value) {
		return new JAXBElement<String>(
				_SetMemberMoneyWechatResponseSetMemberMoneyWechatResult_QNAME,
				String.class, SetMemberMoneyWechatResponse.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "reserveCheckInRoomNewResult", scope = ReserveCheckInRoomNewResponse.class)
	public JAXBElement<String> createReserveCheckInRoomNewResponseReserveCheckInRoomNewResult(
			String value) {
		return new JAXBElement<String>(
				_ReserveCheckInRoomNewResponseReserveCheckInRoomNewResult_QNAME,
				String.class, ReserveCheckInRoomNewResponse.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "GetMediPotoColResult", scope = GetMediPotoColResponse.class)
	public JAXBElement<String> createGetMediPotoColResponseGetMediPotoColResult(
			String value) {
		return new JAXBElement<String>(
				_GetMediPotoColResponseGetMediPotoColResult_QNAME,
				String.class, GetMediPotoColResponse.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "GetSpacialPlanpriceCodeResult", scope = GetSpacialPlanpriceCodeResponse.class)
	public JAXBElement<String> createGetSpacialPlanpriceCodeResponseGetSpacialPlanpriceCodeResult(
			String value) {
		return new JAXBElement<String>(
				_GetSpacialPlanpriceCodeResponseGetSpacialPlanpriceCodeResult_QNAME,
				String.class, GetSpacialPlanpriceCodeResponse.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "setGiftResult", scope = SetGiftResponse.class)
	public JAXBElement<String> createSetGiftResponseSetGiftResult(String value) {
		return new JAXBElement<String>(_SetGiftResponseSetGiftResult_QNAME,
				String.class, SetGiftResponse.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "hotelcode", scope = GetZcodePlanPriceCode.class)
	public JAXBElement<String> createGetZcodePlanPriceCodeHotelcode(String value) {
		return new JAXBElement<String>(_GetZcodePlanPriceCodeHotelcode_QNAME,
				String.class, GetZcodePlanPriceCode.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "GetRoomPriceByLadderResult", scope = GetRoomPriceByLadderResponse.class)
	public JAXBElement<String> createGetRoomPriceByLadderResponseGetRoomPriceByLadderResult(
			String value) {
		return new JAXBElement<String>(
				_GetRoomPriceByLadderResponseGetRoomPriceByLadderResult_QNAME,
				String.class, GetRoomPriceByLadderResponse.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "getOrderInfoResult", scope = GetOrderInfoResponse.class)
	public JAXBElement<String> createGetOrderInfoResponseGetOrderInfoResult(
			String value) {
		return new JAXBElement<String>(
				_GetOrderInfoResponseGetOrderInfoResult_QNAME, String.class,
				GetOrderInfoResponse.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "SetUnitAccountResult", scope = SetUnitAccountResponse.class)
	public JAXBElement<String> createSetUnitAccountResponseSetUnitAccountResult(
			String value) {
		return new JAXBElement<String>(
				_SetUnitAccountResponseSetUnitAccountResult_QNAME,
				String.class, SetUnitAccountResponse.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "payBookGoldResult", scope = PayBookGoldResponse.class)
	public JAXBElement<String> createPayBookGoldResponsePayBookGoldResult(
			String value) {
		return new JAXBElement<String>(
				_PayBookGoldResponsePayBookGoldResult_QNAME, String.class,
				PayBookGoldResponse.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "QueryUOrderAccResult", scope = QueryUOrderAccResponse.class)
	public JAXBElement<String> createQueryUOrderAccResponseQueryUOrderAccResult(
			String value) {
		return new JAXBElement<String>(
				_QueryUOrderAccResponseQueryUOrderAccResult_QNAME,
				String.class, QueryUOrderAccResponse.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "GetRoomPlanPriceSpecialResult", scope = GetRoomPlanPriceSpecialResponse.class)
	public JAXBElement<String> createGetRoomPlanPriceSpecialResponseGetRoomPlanPriceSpecialResult(
			String value) {
		return new JAXBElement<String>(
				_GetRoomPlanPriceSpecialResponseGetRoomPlanPriceSpecialResult_QNAME,
				String.class, GetRoomPlanPriceSpecialResponse.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "getRoomStatusResult", scope = GetRoomStatusResponse.class)
	public JAXBElement<String> createGetRoomStatusResponseGetRoomStatusResult(
			String value) {
		return new JAXBElement<String>(
				_GetRoomStatusResponseGetRoomStatusResult_QNAME, String.class,
				GetRoomStatusResponse.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "message", scope = GetHistoryOrder.class)
	public JAXBElement<String> createGetHistoryOrderMessage(String value) {
		return new JAXBElement<String>(_CreateGuestMessage_QNAME, String.class,
				GetHistoryOrder.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "queryGuestByInResult", scope = QueryGuestByInResponse.class)
	public JAXBElement<String> createQueryGuestByInResponseQueryGuestByInResult(
			String value) {
		return new JAXBElement<String>(
				_QueryGuestByInResponseQueryGuestByInResult_QNAME,
				String.class, QueryGuestByInResponse.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "dcmessage", scope = SetUnitAccount.class)
	public JAXBElement<String> createSetUnitAccountDcmessage(String value) {
		return new JAXBElement<String>(_SetUnitAccountDcmessage_QNAME,
				String.class, SetUnitAccount.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "jsmessage", scope = SetUnitAccount.class)
	public JAXBElement<String> createSetUnitAccountJsmessage(String value) {
		return new JAXBElement<String>(_SetUnitAccountJsmessage_QNAME,
				String.class, SetUnitAccount.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "message", scope = GetRoomPlanByHour.class)
	public JAXBElement<String> createGetRoomPlanByHourMessage(String value) {
		return new JAXBElement<String>(_CreateGuestMessage_QNAME, String.class,
				GetRoomPlanByHour.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "GetOrderNewResult", scope = GetOrderNewResponse.class)
	public JAXBElement<String> createGetOrderNewResponseGetOrderNewResult(
			String value) {
		return new JAXBElement<String>(
				_GetOrderNewResponseGetOrderNewResult_QNAME, String.class,
				GetOrderNewResponse.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "message", scope = GetLeavemessage.class)
	public JAXBElement<String> createGetLeavemessageMessage(String value) {
		return new JAXBElement<String>(_CreateGuestMessage_QNAME, String.class,
				GetLeavemessage.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "GetZcodePlanPriceCodeResult", scope = GetZcodePlanPriceCodeResponse.class)
	public JAXBElement<String> createGetZcodePlanPriceCodeResponseGetZcodePlanPriceCodeResult(
			String value) {
		return new JAXBElement<String>(
				_GetZcodePlanPriceCodeResponseGetZcodePlanPriceCodeResult_QNAME,
				String.class, GetZcodePlanPriceCodeResponse.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "hotelcode", scope = GetSpacialPlanpriceCode.class)
	public JAXBElement<String> createGetSpacialPlanpriceCodeHotelcode(
			String value) {
		return new JAXBElement<String>(_GetZcodePlanPriceCodeHotelcode_QNAME,
				String.class, GetSpacialPlanpriceCode.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "GetHistoryOrderResult", scope = GetHistoryOrderResponse.class)
	public JAXBElement<String> createGetHistoryOrderResponseGetHistoryOrderResult(
			String value) {
		return new JAXBElement<String>(
				_GetHistoryOrderResponseGetHistoryOrderResult_QNAME,
				String.class, GetHistoryOrderResponse.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "message", scope = PayThirdParty.class)
	public JAXBElement<String> createPayThirdPartyMessage(String value) {
		return new JAXBElement<String>(_CreateGuestMessage_QNAME, String.class,
				PayThirdParty.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "GetAccountsYueResult", scope = GetAccountsYueResponse.class)
	public JAXBElement<String> createGetAccountsYueResponseGetAccountsYueResult(
			String value) {
		return new JAXBElement<String>(
				_GetAccountsYueResponseGetAccountsYueResult_QNAME,
				String.class, GetAccountsYueResponse.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "CheckInRoomNewResult", scope = CheckInRoomNewResponse.class)
	public JAXBElement<String> createCheckInRoomNewResponseCheckInRoomNewResult(
			String value) {
		return new JAXBElement<String>(
				_CheckInRoomNewResponseCheckInRoomNewResult_QNAME,
				String.class, CheckInRoomNewResponse.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "message", scope = PayBookGoldByMemberNew.class)
	public JAXBElement<String> createPayBookGoldByMemberNewMessage(String value) {
		return new JAXBElement<String>(_CreateGuestMessage_QNAME, String.class,
				PayBookGoldByMemberNew.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "SetExchangeMemberCancelResult", scope = SetExchangeMemberCancelResponse.class)
	public JAXBElement<String> createSetExchangeMemberCancelResponseSetExchangeMemberCancelResult(
			String value) {
		return new JAXBElement<String>(
				_SetExchangeMemberCancelResponseSetExchangeMemberCancelResult_QNAME,
				String.class, SetExchangeMemberCancelResponse.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "message", scope = GetRoomStatus.class)
	public JAXBElement<String> createGetRoomStatusMessage(String value) {
		return new JAXBElement<String>(_CreateGuestMessage_QNAME, String.class,
				GetRoomStatus.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "message", scope = SetMemberCoustomerNew.class)
	public JAXBElement<String> createSetMemberCoustomerNewMessage(String value) {
		return new JAXBElement<String>(_CreateGuestMessage_QNAME, String.class,
				SetMemberCoustomerNew.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "message", scope = UpdateMemberGuest.class)
	public JAXBElement<String> createUpdateMemberGuestMessage(String value) {
		return new JAXBElement<String>(_CreateGuestMessage_QNAME, String.class,
				UpdateMemberGuest.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "SetExchangeResult", scope = SetExchangeResponse.class)
	public JAXBElement<String> createSetExchangeResponseSetExchangeResult(
			String value) {
		return new JAXBElement<String>(
				_SetExchangeResponseSetExchangeResult_QNAME, String.class,
				SetExchangeResponse.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "GetMemberStoreActiveResult", scope = GetMemberStoreActiveResponse.class)
	public JAXBElement<String> createGetMemberStoreActiveResponseGetMemberStoreActiveResult(
			String value) {
		return new JAXBElement<String>(
				_GetMemberStoreActiveResponseGetMemberStoreActiveResult_QNAME,
				String.class, GetMemberStoreActiveResponse.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "message", scope = SetMemberCoustomer.class)
	public JAXBElement<String> createSetMemberCoustomerMessage(String value) {
		return new JAXBElement<String>(_CreateGuestMessage_QNAME, String.class,
				SetMemberCoustomer.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "checkMemberWxResult", scope = CheckMemberWxResponse.class)
	public JAXBElement<String> createCheckMemberWxResponseCheckMemberWxResult(
			String value) {
		return new JAXBElement<String>(
				_CheckMemberWxResponseCheckMemberWxResult_QNAME, String.class,
				CheckMemberWxResponse.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "message", scope = GetRoomType.class)
	public JAXBElement<String> createGetRoomTypeMessage(String value) {
		return new JAXBElement<String>(_CreateGuestMessage_QNAME, String.class,
				GetRoomType.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "message", scope = RefundThirdParty.class)
	public JAXBElement<String> createRefundThirdPartyMessage(String value) {
		return new JAXBElement<String>(_CreateGuestMessage_QNAME, String.class,
				RefundThirdParty.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "getRoomStatusNewResult", scope = GetRoomStatusNewResponse.class)
	public JAXBElement<String> createGetRoomStatusNewResponseGetRoomStatusNewResult(
			String value) {
		return new JAXBElement<String>(
				_GetRoomStatusNewResponseGetRoomStatusNewResult_QNAME,
				String.class, GetRoomStatusNewResponse.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "SetaccountsResult", scope = SetaccountsResponse.class)
	public JAXBElement<String> createSetaccountsResponseSetaccountsResult(
			String value) {
		return new JAXBElement<String>(
				_SetaccountsResponseSetaccountsResult_QNAME, String.class,
				SetaccountsResponse.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "message", scope = GetMemberStoreActive.class)
	public JAXBElement<String> createGetMemberStoreActiveMessage(String value) {
		return new JAXBElement<String>(_CreateGuestMessage_QNAME, String.class,
				GetMemberStoreActive.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "SetMemberTypeResult", scope = SetMemberTypeResponse.class)
	public JAXBElement<String> createSetMemberTypeResponseSetMemberTypeResult(
			String value) {
		return new JAXBElement<String>(
				_SetMemberTypeResponseSetMemberTypeResult_QNAME, String.class,
				SetMemberTypeResponse.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "message", scope = SendService.class)
	public JAXBElement<String> createSendServiceMessage(String value) {
		return new JAXBElement<String>(_CreateGuestMessage_QNAME, String.class,
				SendService.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "GetRoomPriceResult", scope = GetRoomPriceResponse.class)
	public JAXBElement<String> createGetRoomPriceResponseGetRoomPriceResult(
			String value) {
		return new JAXBElement<String>(
				_GetRoomPriceResponseGetRoomPriceResult_QNAME, String.class,
				GetRoomPriceResponse.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "message", scope = SelectGuest.class)
	public JAXBElement<String> createSelectGuestMessage(String value) {
		return new JAXBElement<String>(_CreateGuestMessage_QNAME, String.class,
				SelectGuest.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "message", scope = PayBookGoldByMember.class)
	public JAXBElement<String> createPayBookGoldByMemberMessage(String value) {
		return new JAXBElement<String>(_CreateGuestMessage_QNAME, String.class,
				PayBookGoldByMember.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "setReserveroomResult", scope = SetReserveroomResponse.class)
	public JAXBElement<String> createSetReserveroomResponseSetReserveroomResult(
			String value) {
		return new JAXBElement<String>(
				_SetReserveroomResponseSetReserveroomResult_QNAME,
				String.class, SetReserveroomResponse.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "ThirdSetMemberGuestResult", scope = ThirdSetMemberGuestResponse.class)
	public JAXBElement<String> createThirdSetMemberGuestResponseThirdSetMemberGuestResult(
			String value) {
		return new JAXBElement<String>(
				_ThirdSetMemberGuestResponseThirdSetMemberGuestResult_QNAME,
				String.class, ThirdSetMemberGuestResponse.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "GetstandardResult", scope = GetstandardResponse.class)
	public JAXBElement<String> createGetstandardResponseGetstandardResult(
			String value) {
		return new JAXBElement<String>(
				_GetstandardResponseGetstandardResult_QNAME, String.class,
				GetstandardResponse.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "message", scope = GetReserve.class)
	public JAXBElement<String> createGetReserveMessage(String value) {
		return new JAXBElement<String>(_CreateGuestMessage_QNAME, String.class,
				GetReserve.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "message", scope = SetExchangeMemberPassword.class)
	public JAXBElement<String> createSetExchangeMemberPasswordMessage(
			String value) {
		return new JAXBElement<String>(_CreateGuestMessage_QNAME, String.class,
				SetExchangeMemberPassword.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "InsertMemberGuestResult", scope = InsertMemberGuestResponse.class)
	public JAXBElement<String> createInsertMemberGuestResponseInsertMemberGuestResult(
			String value) {
		return new JAXBElement<String>(
				_InsertMemberGuestResponseInsertMemberGuestResult_QNAME,
				String.class, InsertMemberGuestResponse.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "UpdateMemberGuestResult", scope = UpdateMemberGuestResponse.class)
	public JAXBElement<String> createUpdateMemberGuestResponseUpdateMemberGuestResult(
			String value) {
		return new JAXBElement<String>(
				_UpdateMemberGuestResponseUpdateMemberGuestResult_QNAME,
				String.class, UpdateMemberGuestResponse.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "GetRoomPlanByHourResult", scope = GetRoomPlanByHourResponse.class)
	public JAXBElement<String> createGetRoomPlanByHourResponseGetRoomPlanByHourResult(
			String value) {
		return new JAXBElement<String>(
				_GetRoomPlanByHourResponseGetRoomPlanByHourResult_QNAME,
				String.class, GetRoomPlanByHourResponse.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "message", scope = CheckInRoom.class)
	public JAXBElement<String> createCheckInRoomMessage(String value) {
		return new JAXBElement<String>(_CreateGuestMessage_QNAME, String.class,
				CheckInRoom.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "message", scope = SetActive.class)
	public JAXBElement<String> createSetActiveMessage(String value) {
		return new JAXBElement<String>(_CreateGuestMessage_QNAME, String.class,
				SetActive.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "message", scope = SetRoomStates.class)
	public JAXBElement<String> createSetRoomStatesMessage(String value) {
		return new JAXBElement<String>(_CreateGuestMessage_QNAME, String.class,
				SetRoomStates.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "SetExchangeMemberPasswordResult", scope = SetExchangeMemberPasswordResponse.class)
	public JAXBElement<String> createSetExchangeMemberPasswordResponseSetExchangeMemberPasswordResult(
			String value) {
		return new JAXBElement<String>(
				_SetExchangeMemberPasswordResponseSetExchangeMemberPasswordResult_QNAME,
				String.class, SetExchangeMemberPasswordResponse.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "message", scope = SendProocessByRoom.class)
	public JAXBElement<String> createSendProocessByRoomMessage(String value) {
		return new JAXBElement<String>(_CreateGuestMessage_QNAME, String.class,
				SendProocessByRoom.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "hotelcode", scope = Getstandard.class)
	public JAXBElement<String> createGetstandardHotelcode(String value) {
		return new JAXBElement<String>(_GetZcodePlanPriceCodeHotelcode_QNAME,
				String.class, Getstandard.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "message", scope = CheckMemberWx.class)
	public JAXBElement<String> createCheckMemberWxMessage(String value) {
		return new JAXBElement<String>(_CreateGuestMessage_QNAME, String.class,
				CheckMemberWx.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "message", scope = GetRoomPlanPriceSpecial.class)
	public JAXBElement<String> createGetRoomPlanPriceSpecialMessage(String value) {
		return new JAXBElement<String>(_CreateGuestMessage_QNAME, String.class,
				GetRoomPlanPriceSpecial.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "GetReserveResult", scope = GetReserveResponse.class)
	public JAXBElement<String> createGetReserveResponseGetReserveResult(
			String value) {
		return new JAXBElement<String>(
				_GetReserveResponseGetReserveResult_QNAME, String.class,
				GetReserveResponse.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "message", scope = SaveOutByroom.class)
	public JAXBElement<String> createSaveOutByroomMessage(String value) {
		return new JAXBElement<String>(_CreateGuestMessage_QNAME, String.class,
				SaveOutByroom.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "SetExchangeMemberCardNoResult", scope = SetExchangeMemberCardNoResponse.class)
	public JAXBElement<String> createSetExchangeMemberCardNoResponseSetExchangeMemberCardNoResult(
			String value) {
		return new JAXBElement<String>(
				_SetExchangeMemberCardNoResponseSetExchangeMemberCardNoResult_QNAME,
				String.class, SetExchangeMemberCardNoResponse.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "message", scope = QueryUOrderAcc.class)
	public JAXBElement<String> createQueryUOrderAccMessage(String value) {
		return new JAXBElement<String>(_CreateGuestMessage_QNAME, String.class,
				QueryUOrderAcc.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "message", scope = QueryGuestByIn.class)
	public JAXBElement<String> createQueryGuestByInMessage(String value) {
		return new JAXBElement<String>(_CreateGuestMessage_QNAME, String.class,
				QueryGuestByIn.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "message", scope = SetMediPotolCol.class)
	public JAXBElement<String> createSetMediPotolColMessage(String value) {
		return new JAXBElement<String>(_CreateGuestMessage_QNAME, String.class,
				SetMediPotolCol.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "message", scope = GetOrder.class)
	public JAXBElement<String> createGetOrderMessage(String value) {
		return new JAXBElement<String>(_CreateGuestMessage_QNAME, String.class,
				GetOrder.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "AgainCheckInroomResult", scope = AgainCheckInroomResponse.class)
	public JAXBElement<String> createAgainCheckInroomResponseAgainCheckInroomResult(
			String value) {
		return new JAXBElement<String>(
				_AgainCheckInroomResponseAgainCheckInroomResult_QNAME,
				String.class, AgainCheckInroomResponse.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "SetActiveResult", scope = SetActiveResponse.class)
	public JAXBElement<String> createSetActiveResponseSetActiveResult(
			String value) {
		return new JAXBElement<String>(_SetActiveResponseSetActiveResult_QNAME,
				String.class, SetActiveResponse.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "SetMemberCoustomerResult", scope = SetMemberCoustomerResponse.class)
	public JAXBElement<String> createSetMemberCoustomerResponseSetMemberCoustomerResult(
			String value) {
		return new JAXBElement<String>(
				_SetMemberCoustomerResponseSetMemberCoustomerResult_QNAME,
				String.class, SetMemberCoustomerResponse.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "SendtateByCardResult", scope = SendtateByCardResponse.class)
	public JAXBElement<String> createSendtateByCardResponseSendtateByCardResult(
			String value) {
		return new JAXBElement<String>(
				_SendtateByCardResponseSendtateByCardResult_QNAME,
				String.class, SendtateByCardResponse.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "message", scope = AgainCheckInroom.class)
	public JAXBElement<String> createAgainCheckInroomMessage(String value) {
		return new JAXBElement<String>(_CreateGuestMessage_QNAME, String.class,
				AgainCheckInroom.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "GetLeavemessageResult", scope = GetLeavemessageResponse.class)
	public JAXBElement<String> createGetLeavemessageResponseGetLeavemessageResult(
			String value) {
		return new JAXBElement<String>(
				_GetLeavemessageResponseGetLeavemessageResult_QNAME,
				String.class, GetLeavemessageResponse.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "SaveOutByroomResult", scope = SaveOutByroomResponse.class)
	public JAXBElement<String> createSaveOutByroomResponseSaveOutByroomResult(
			String value) {
		return new JAXBElement<String>(
				_SaveOutByroomResponseSaveOutByroomResult_QNAME, String.class,
				SaveOutByroomResponse.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "message", scope = InsertMemberGuest.class)
	public JAXBElement<String> createInsertMemberGuestMessage(String value) {
		return new JAXBElement<String>(_CreateGuestMessage_QNAME, String.class,
				InsertMemberGuest.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "message", scope = Setaccounts.class)
	public JAXBElement<String> createSetaccountsMessage(String value) {
		return new JAXBElement<String>(_CreateGuestMessage_QNAME, String.class,
				Setaccounts.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "message", scope = SetExchangeMemberCancel.class)
	public JAXBElement<String> createSetExchangeMemberCancelMessage(String value) {
		return new JAXBElement<String>(_CreateGuestMessage_QNAME, String.class,
				SetExchangeMemberCancel.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "message", scope = SetMemberType.class)
	public JAXBElement<String> createSetMemberTypeMessage(String value) {
		return new JAXBElement<String>(_CreateGuestMessage_QNAME, String.class,
				SetMemberType.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "CancelBookrqResult", scope = CancelBookrqResponse.class)
	public JAXBElement<String> createCancelBookrqResponseCancelBookrqResult(
			String value) {
		return new JAXBElement<String>(
				_CancelBookrqResponseCancelBookrqResult_QNAME, String.class,
				CancelBookrqResponse.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "message", scope = PayBookGold.class)
	public JAXBElement<String> createPayBookGoldMessage(String value) {
		return new JAXBElement<String>(_CreateGuestMessage_QNAME, String.class,
				PayBookGold.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "getBottomPriceResult", scope = GetBottomPriceResponse.class)
	public JAXBElement<String> createGetBottomPriceResponseGetBottomPriceResult(
			String value) {
		return new JAXBElement<String>(
				_GetBottomPriceResponseGetBottomPriceResult_QNAME,
				String.class, GetBottomPriceResponse.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "GethHotelcodeResult", scope = GethHotelcodeResponse.class)
	public JAXBElement<String> createGethHotelcodeResponseGethHotelcodeResult(
			String value) {
		return new JAXBElement<String>(
				_GethHotelcodeResponseGethHotelcodeResult_QNAME, String.class,
				GethHotelcodeResponse.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "selectGuestResult", scope = SelectGuestResponse.class)
	public JAXBElement<String> createSelectGuestResponseSelectGuestResult(
			String value) {
		return new JAXBElement<String>(
				_SelectGuestResponseSelectGuestResult_QNAME, String.class,
				SelectGuestResponse.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "message", scope = GetStateByRoom.class)
	public JAXBElement<String> createGetStateByRoomMessage(String value) {
		return new JAXBElement<String>(_CreateGuestMessage_QNAME, String.class,
				GetStateByRoom.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "message", scope = ReserveCheckInRoomNew.class)
	public JAXBElement<String> createReserveCheckInRoomNewMessage(String value) {
		return new JAXBElement<String>(_CreateGuestMessage_QNAME, String.class,
				ReserveCheckInRoomNew.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "SetUnitPotoColResult", scope = SetUnitPotoColResponse.class)
	public JAXBElement<String> createSetUnitPotoColResponseSetUnitPotoColResult(
			String value) {
		return new JAXBElement<String>(
				_SetUnitPotoColResponseSetUnitPotoColResult_QNAME,
				String.class, SetUnitPotoColResponse.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "message", scope = CancelThirdParty.class)
	public JAXBElement<String> createCancelThirdPartyMessage(String value) {
		return new JAXBElement<String>(_CreateGuestMessage_QNAME, String.class,
				CancelThirdParty.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "message", scope = GetBottomPrice.class)
	public JAXBElement<String> createGetBottomPriceMessage(String value) {
		return new JAXBElement<String>(_CreateGuestMessage_QNAME, String.class,
				GetBottomPrice.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "message", scope = CancelBookrq.class)
	public JAXBElement<String> createCancelBookrqMessage(String value) {
		return new JAXBElement<String>(_CreateGuestMessage_QNAME, String.class,
				CancelBookrq.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "message", scope = SetUnitMdiAccounts.class)
	public JAXBElement<String> createSetUnitMdiAccountsMessage(String value) {
		return new JAXBElement<String>(_CreateGuestMessage_QNAME, String.class,
				SetUnitMdiAccounts.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "message", scope = CheckInRoomNew.class)
	public JAXBElement<String> createCheckInRoomNewMessage(String value) {
		return new JAXBElement<String>(_CreateGuestMessage_QNAME, String.class,
				CheckInRoomNew.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "message", scope = CheckMember.class)
	public JAXBElement<String> createCheckMemberMessage(String value) {
		return new JAXBElement<String>(_CreateGuestMessage_QNAME, String.class,
				CheckMember.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "message", scope = SetUnitPotoCol.class)
	public JAXBElement<String> createSetUnitPotoColMessage(String value) {
		return new JAXBElement<String>(_CreateGuestMessage_QNAME, String.class,
				SetUnitPotoCol.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "message", scope = GetMemberType.class)
	public JAXBElement<String> createGetMemberTypeMessage(String value) {
		return new JAXBElement<String>(_CreateGuestMessage_QNAME, String.class,
				GetMemberType.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "createGuestResult", scope = CreateGuestResponse.class)
	public JAXBElement<String> createCreateGuestResponseCreateGuestResult(
			String value) {
		return new JAXBElement<String>(
				_CreateGuestResponseCreateGuestResult_QNAME, String.class,
				CreateGuestResponse.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "createBookrqResult", scope = CreateBookrqResponse.class)
	public JAXBElement<String> createCreateBookrqResponseCreateBookrqResult(
			String value) {
		return new JAXBElement<String>(
				_CreateBookrqResponseCreateBookrqResult_QNAME, String.class,
				CreateBookrqResponse.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "sendServiceResult", scope = SendServiceResponse.class)
	public JAXBElement<String> createSendServiceResponseSendServiceResult(
			String value) {
		return new JAXBElement<String>(
				_SendServiceResponseSendServiceResult_QNAME, String.class,
				SendServiceResponse.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "GethHotelcodeNewResult", scope = GethHotelcodeNewResponse.class)
	public JAXBElement<String> createGethHotelcodeNewResponseGethHotelcodeNewResult(
			String value) {
		return new JAXBElement<String>(
				_GethHotelcodeNewResponseGethHotelcodeNewResult_QNAME,
				String.class, GethHotelcodeNewResponse.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "payThirdPartyResult", scope = PayThirdPartyResponse.class)
	public JAXBElement<String> createPayThirdPartyResponsePayThirdPartyResult(
			String value) {
		return new JAXBElement<String>(
				_PayThirdPartyResponsePayThirdPartyResult_QNAME, String.class,
				PayThirdPartyResponse.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "money", scope = SetMemberMoney.class)
	public JAXBElement<String> createSetMemberMoneyMoney(String value) {
		return new JAXBElement<String>(_SetMemberMoneyMoney_QNAME,
				String.class, SetMemberMoney.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "message", scope = ThirdSetMemberGuest.class)
	public JAXBElement<String> createThirdSetMemberGuestMessage(String value) {
		return new JAXBElement<String>(_CreateGuestMessage_QNAME, String.class,
				ThirdSetMemberGuest.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "message", scope = GetAccountsYue.class)
	public JAXBElement<String> createGetAccountsYueMessage(String value) {
		return new JAXBElement<String>(_CreateGuestMessage_QNAME, String.class,
				GetAccountsYue.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "message", scope = GetRoomPrice.class)
	public JAXBElement<String> createGetRoomPriceMessage(String value) {
		return new JAXBElement<String>(_CreateGuestMessage_QNAME, String.class,
				GetRoomPrice.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "GetUnitPotoColResult", scope = GetUnitPotoColResponse.class)
	public JAXBElement<String> createGetUnitPotoColResponseGetUnitPotoColResult(
			String value) {
		return new JAXBElement<String>(
				_GetUnitPotoColResponseGetUnitPotoColResult_QNAME,
				String.class, GetUnitPotoColResponse.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "message", scope = GetMediPotoCol.class)
	public JAXBElement<String> createGetMediPotoColMessage(String value) {
		return new JAXBElement<String>(_CreateGuestMessage_QNAME, String.class,
				GetMediPotoCol.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "setRoomStatesResult", scope = SetRoomStatesResponse.class)
	public JAXBElement<String> createSetRoomStatesResponseSetRoomStatesResult(
			String value) {
		return new JAXBElement<String>(
				_SetRoomStatesResponseSetRoomStatesResult_QNAME, String.class,
				SetRoomStatesResponse.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "reserveCheckInRoomResult", scope = ReserveCheckInRoomResponse.class)
	public JAXBElement<String> createReserveCheckInRoomResponseReserveCheckInRoomResult(
			String value) {
		return new JAXBElement<String>(
				_ReserveCheckInRoomResponseReserveCheckInRoomResult_QNAME,
				String.class, ReserveCheckInRoomResponse.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "CheckInRoomResult", scope = CheckInRoomResponse.class)
	public JAXBElement<String> createCheckInRoomResponseCheckInRoomResult(
			String value) {
		return new JAXBElement<String>(
				_CheckInRoomResponseCheckInRoomResult_QNAME, String.class,
				CheckInRoomResponse.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "message", scope = IsExistsAccounts.class)
	public JAXBElement<String> createIsExistsAccountsMessage(String value) {
		return new JAXBElement<String>(_CreateGuestMessage_QNAME, String.class,
				IsExistsAccounts.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "message", scope = GetRoomPriceByLadder.class)
	public JAXBElement<String> createGetRoomPriceByLadderMessage(String value) {
		return new JAXBElement<String>(_CreateGuestMessage_QNAME, String.class,
				GetRoomPriceByLadder.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "GetOrderResult", scope = GetOrderResponse.class)
	public JAXBElement<String> createGetOrderResponseGetOrderResult(String value) {
		return new JAXBElement<String>(_GetOrderResponseGetOrderResult_QNAME,
				String.class, GetOrderResponse.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "message", scope = SetTogetherByRoom.class)
	public JAXBElement<String> createSetTogetherByRoomMessage(String value) {
		return new JAXBElement<String>(_CreateGuestMessage_QNAME, String.class,
				SetTogetherByRoom.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "SetMemberMoneyResult", scope = SetMemberMoneyResponse.class)
	public JAXBElement<String> createSetMemberMoneyResponseSetMemberMoneyResult(
			String value) {
		return new JAXBElement<String>(
				_SetMemberMoneyResponseSetMemberMoneyResult_QNAME,
				String.class, SetMemberMoneyResponse.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "GetMemberTypeResult", scope = GetMemberTypeResponse.class)
	public JAXBElement<String> createGetMemberTypeResponseGetMemberTypeResult(
			String value) {
		return new JAXBElement<String>(
				_GetMemberTypeResponseGetMemberTypeResult_QNAME, String.class,
				GetMemberTypeResponse.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://tempuri.org/", name = "message", scope = SetMemberMoneyWechat.class)
	public JAXBElement<String> createSetMemberMoneyWechatMessage(String value) {
		return new JAXBElement<String>(_CreateGuestMessage_QNAME, String.class,
				SetMemberMoneyWechat.class, value);
	}

}
