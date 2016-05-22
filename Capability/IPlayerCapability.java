package MineMineNoMi3.Capability;

public interface IPlayerCapability
{
	public int getDoriki();
	public void addDoriki(int i);
	public void decDoriki(int i);
	public void setDoriki(int i);
	
	public int getBounty();
	public void addBounty(int i);
	public void decBounty(int i);
	public void setBounty(int i);
	
	public int getBelly();
	public void addBelly(int i);
	public void decBelly(int i);
	public void setBelly(int i);
	
	public int getExtol();
	public void addExtol(int i);
	public void decExtol(int i);
	public void setExtol(int i);
	
	public boolean isLogia();
	public void setIsLogia(boolean isLogia);
	
	public String getJob();
	public void setJob(String job);
	
	public String getRace();
	public void setRace(String race);
	
	public String getFaction();
	public void setFaction(String faction);
	
	public String getUsedFruit();
	public void setUsedFruit(String name);
	
	public boolean hasHeart();
	public void setHasHeart(boolean hasHeart);
	
	public boolean hasShadow();
	public void setHasShadow(boolean hasShadow);
	
	public void setGear(byte gear);
	public byte getGear();
	
	public boolean isFirstTime();
	public void setFirstTime(boolean firstTime);
	public void firstTimePass();
	
	public void setAnswerBySlot(int slot, int i);
	public int getAnswerBySlot(int slot);
	public void setAnswers(int[] a);
	public int[] getAnswers();
}
