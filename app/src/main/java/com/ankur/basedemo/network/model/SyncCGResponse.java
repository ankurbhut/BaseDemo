package com.ankur.basedemo.network.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SyncCGResponse{

	@SerializedName("ItemCode")
	private String itemCode;

	@SerializedName("TotalQty")
	private int totalQty;

	@SerializedName("CreatedBy")
	private int createdBy;

	@SerializedName("CartonVolume")
	private double cartonVolume;

	@SerializedName("CartonType")
	private String cartonType;

	@SerializedName("ScannerID")
	private String scannerID;

	@SerializedName("CartonHeight")
	private double cartonHeight;

	@SerializedName("PlantID")
	private int plantID;

	@SerializedName("QCStockOid")
	private List<Integer> qCStockOid;

	@SerializedName("CartonWidth")
	private double cartonWidth;

	@SerializedName("Batch")
	private String batch;

	@SerializedName("CartonLength")
	private double cartonLength;

	@SerializedName("SONo")
	private int sONo;

	@SerializedName("ProPlanDetlOid")
	private int proPlanDetlOid;

	public void setItemCode(String itemCode){
		this.itemCode = itemCode;
	}

	public String getItemCode(){
		return itemCode;
	}

	public void setTotalQty(int totalQty){
		this.totalQty = totalQty;
	}

	public int getTotalQty(){
		return totalQty;
	}

	public void setCreatedBy(int createdBy){
		this.createdBy = createdBy;
	}

	public int getCreatedBy(){
		return createdBy;
	}

	public void setCartonVolume(double cartonVolume){
		this.cartonVolume = cartonVolume;
	}

	public double getCartonVolume(){
		return cartonVolume;
	}

	public void setCartonType(String cartonType){
		this.cartonType = cartonType;
	}

	public String getCartonType(){
		return cartonType;
	}

	public void setScannerID(String scannerID){
		this.scannerID = scannerID;
	}

	public String getScannerID(){
		return scannerID;
	}

	public void setCartonHeight(double cartonHeight){
		this.cartonHeight = cartonHeight;
	}

	public double getCartonHeight(){
		return cartonHeight;
	}

	public void setPlantID(int plantID){
		this.plantID = plantID;
	}

	public int getPlantID(){
		return plantID;
	}

	public void setQCStockOid(List<Integer> qCStockOid){
		this.qCStockOid = qCStockOid;
	}

	public List<Integer> getQCStockOid(){
		return qCStockOid;
	}

	public void setCartonWidth(double cartonWidth){
		this.cartonWidth = cartonWidth;
	}

	public double getCartonWidth(){
		return cartonWidth;
	}

	public void setBatch(String batch){
		this.batch = batch;
	}

	public String getBatch(){
		return batch;
	}

	public void setCartonLength(double cartonLength){
		this.cartonLength = cartonLength;
	}

	public double getCartonLength(){
		return cartonLength;
	}

	public void setSONo(int sONo){
		this.sONo = sONo;
	}

	public int getSONo(){
		return sONo;
	}

	public void setProPlanDetlOid(int proPlanDetlOid){
		this.proPlanDetlOid = proPlanDetlOid;
	}

	public int getProPlanDetlOid(){
		return proPlanDetlOid;
	}

	@Override
 	public String toString(){
		return 
			"SyncCGResponse{" + 
			"itemCode = '" + itemCode + '\'' + 
			",totalQty = '" + totalQty + '\'' + 
			",createdBy = '" + createdBy + '\'' + 
			",cartonVolume = '" + cartonVolume + '\'' + 
			",cartonType = '" + cartonType + '\'' + 
			",scannerID = '" + scannerID + '\'' + 
			",cartonHeight = '" + cartonHeight + '\'' + 
			",plantID = '" + plantID + '\'' + 
			",qCStockOid = '" + qCStockOid + '\'' + 
			",cartonWidth = '" + cartonWidth + '\'' + 
			",batch = '" + batch + '\'' + 
			",cartonLength = '" + cartonLength + '\'' + 
			",sONo = '" + sONo + '\'' + 
			",proPlanDetlOid = '" + proPlanDetlOid + '\'' + 
			"}";
		}
}