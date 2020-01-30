package com.ankur.basedemo.db.dbmodel;

public class SyncCG{
	private String serialNo;
	private String itemCode;
	private int totalPending;
	private String batch;
	private int totalScan;
	private String soNO;
	private int id;
	private String packingLineID;
	private int cartonSize;
	private int qCStockOid;
	private double mCartonLength;
	private double mCartonWidth;
	private double mCartonHeight;
	private double mCartonVolume;
	private boolean unUsed =false;

	public SyncCG(){

	}

	public SyncCG(
			int id,
			String serialNo,
			String itemCode,
			int totalPending,
			String batch,
			int totalScan,
			String soNO,
			String packingLineID,
			int cartonSize,
			int qCStockOid,
			double mCartonLength,
			double mCartonWidth,
			double mCartonHeight,
			double mCartonVolume) {

		this.id = id;
		this.serialNo = serialNo;
		this.itemCode = itemCode;
		this.totalPending = totalPending;
		this.batch = batch;
		this.totalScan = totalScan;
		this.soNO = soNO;
		this.packingLineID = packingLineID;
		this.cartonSize = cartonSize;
		this.qCStockOid = qCStockOid;
		this.mCartonLength = mCartonLength;
		this.mCartonWidth = mCartonWidth;
		this.mCartonHeight = mCartonHeight;
		this.mCartonVolume = mCartonVolume;
	}

	public String getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public int getTotalPending() {
		return totalPending;
	}

	public void setTotalPending(int totalPending) {
		this.totalPending = totalPending;
	}

	public String getBatch() {
		return batch;
	}

	public void setBatch(String batch) {
		this.batch = batch;
	}

	public int getTotalScan() {
		return totalScan;
	}

	public void setTotalScan(int totalScan) {
		this.totalScan = totalScan;
	}

	public String getSoNO() {
		return soNO;
	}

	public void setSoNO(String soNO) {
		this.soNO = soNO;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPackingLineID() {
		return packingLineID;
	}

	public void setPackingLineID(String packingLineID) {
		this.packingLineID = packingLineID;
	}

	public int getCartonSize() {
		return cartonSize;
	}

	public void setCartonSize(int cartonSize) {
		this.cartonSize = cartonSize;
	}

	public int getqCStockOid() {
		return qCStockOid;
	}

	public void setqCStockOid(int qCStockOid) {
		this.qCStockOid = qCStockOid;
	}

	public double getmCartonLength() {
		return mCartonLength;
	}

	public void setmCartonLength(double mCartonLength) {
		this.mCartonLength = mCartonLength;
	}

	public double getmCartonWidth() {
		return mCartonWidth;
	}

	public void setmCartonWidth(double mCartonWidth) {
		this.mCartonWidth = mCartonWidth;
	}

	public double getmCartonHeight() {
		return mCartonHeight;
	}

	public void setmCartonHeight(double mCartonHeight) {
		this.mCartonHeight = mCartonHeight;
	}

	public double getmCartonVolume() {
		return mCartonVolume;
	}

	public void setmCartonVolume(double mCartonVolume) {
		this.mCartonVolume = mCartonVolume;
	}

	public boolean isUnUsed() {
		return unUsed;
	}

	public void setUnUsed(boolean unUsed) {
		this.unUsed = unUsed;
	}

	@Override
	public String toString() {
		return "SyncCG{" +
				"serialNo='" + serialNo + '\'' +
				", itemCode='" + itemCode + '\'' +
				", totalPending=" + totalPending +
				", batch='" + batch + '\'' +
				", totalScan=" + totalScan +
				", soNO='" + soNO + '\'' +
				", id=" + id +
				", packingLineID='" + packingLineID + '\'' +
				", cartonSize=" + cartonSize +
				", qCStockOid=" + qCStockOid +
				", mCartonLength=" + mCartonLength +
				", mCartonWidth=" + mCartonWidth +
				", mCartonHeight=" + mCartonHeight +
				", mCartonVolume=" + mCartonVolume +
				", unUsed=" + unUsed +
				'}';
	}
}
