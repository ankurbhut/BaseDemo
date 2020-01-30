package com.ankur.basedemo.network.model;

import com.google.gson.annotations.SerializedName;

public class CGCheckPackingLineResponse {

	@SerializedName("STATUS")
	private boolean sTATUS;

	@SerializedName("CartonWidth")
	private int cartonWidth;

	@SerializedName("ERRORMSG")
	private String eRRORMSG;

	@SerializedName("CartonVolume")
	private double cartonVolume;

	@SerializedName("ITEMDESC")
	private String iTEMDESC;

	@SerializedName("BATCH")
	private String bATCH;

	@SerializedName("CartonPackSize")
	private int cartonPackSize;

	@SerializedName("CartonLength")
	private int cartonLength;

	@SerializedName("SONO")
	private int sONO;

	@SerializedName("ITEMCODE")
	private String iTEMCODE;

	@SerializedName("CartonHeight")
	private int cartonHeight;

	public void setSTATUS(boolean sTATUS){
		this.sTATUS = sTATUS;
	}

	public boolean isSTATUS(){
		return sTATUS;
	}

	public void setCartonWidth(int cartonWidth){
		this.cartonWidth = cartonWidth;
	}

	public int getCartonWidth(){
		return cartonWidth;
	}

	public void setERRORMSG(String eRRORMSG){
		this.eRRORMSG = eRRORMSG;
	}

	public String getERRORMSG(){
		return eRRORMSG;
	}

	public void setCartonVolume(double cartonVolume){
		this.cartonVolume = cartonVolume;
	}

	public double getCartonVolume(){
		return cartonVolume;
	}

	public void setITEMDESC(String iTEMDESC){
		this.iTEMDESC = iTEMDESC;
	}

	public String getITEMDESC(){
		return iTEMDESC;
	}

	public void setBATCH(String bATCH){
		this.bATCH = bATCH;
	}

	public String getBATCH(){
		return bATCH;
	}

	public void setCartonPackSize(int cartonPackSize){
		this.cartonPackSize = cartonPackSize;
	}

	public int getCartonPackSize(){
		return cartonPackSize;
	}

	public void setCartonLength(int cartonLength){
		this.cartonLength = cartonLength;
	}

	public int getCartonLength(){
		return cartonLength;
	}

	public void setSONO(int sONO){
		this.sONO = sONO;
	}

	public int getSONO(){
		return sONO;
	}

	public void setITEMCODE(String iTEMCODE){
		this.iTEMCODE = iTEMCODE;
	}

	public String getITEMCODE(){
		return iTEMCODE;
	}

	public void setCartonHeight(int cartonHeight){
		this.cartonHeight = cartonHeight;
	}

	public int getCartonHeight(){
		return cartonHeight;
	}

	@Override
 	public String toString(){
		return 
			"CGCheckPackingLineResponse{" + 
			"sTATUS = '" + sTATUS + '\'' + 
			",cartonWidth = '" + cartonWidth + '\'' + 
			",eRRORMSG = '" + eRRORMSG + '\'' + 
			",cartonVolume = '" + cartonVolume + '\'' + 
			",iTEMDESC = '" + iTEMDESC + '\'' + 
			",bATCH = '" + bATCH + '\'' + 
			",cartonPackSize = '" + cartonPackSize + '\'' + 
			",cartonLength = '" + cartonLength + '\'' + 
			",sONO = '" + sONO + '\'' + 
			",iTEMCODE = '" + iTEMCODE + '\'' + 
			",cartonHeight = '" + cartonHeight + '\'' + 
			"}";
		}
}