package WyPI.quests;

import net.minecraft.entity.player.EntityPlayer;

public class Quest
{

	public Quest(String name)
	{
		
	}
	
	public void onQuestAccept(EntityPlayer player) {}
	
	public void onQuestFinish(EntityPlayer player) {}
	
	public void addObjective(QuestObjective objective) {}
}
