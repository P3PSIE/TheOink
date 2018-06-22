package p3psie.theoink.commands;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.Entity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;
import p3psie.theoink.entities.OinkBacon;
import p3psie.theoink.entities.OinkSausage;
import p3psie.theoink.init.OinkEntities;

public class CommandKillPigs extends CommandBase {
    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }

    @Override
    public String getName() {
        return "killpigs";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "commands.theoink.killpigs.usage";
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        World world = server.getEntityWorld();

        for(int i = 0; i < world.loadedEntityList.size(); i++){
            Entity entity = server.getEntityWorld().getLoadedEntityList().get(i);

            if(entity instanceof OinkBacon)
                entity.setDead();

            if(entity instanceof OinkSausage)
                entity.setDead();
        }

        if(!world.isRemote){
            sender.sendMessage(new TextComponentTranslation("commands.theoink.killpigs.output"));
        }
    }
}