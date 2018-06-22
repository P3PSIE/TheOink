package p3psie.theoink.commands;

import net.minecraft.command.ICommandSender;
import net.minecraftforge.server.command.CommandTreeBase;
import net.minecraftforge.server.command.CommandTreeHelp;

public class CommandsOink extends CommandTreeBase {

    public CommandsOink(){
        addSubcommand(new CommandKillPigs());


        addSubcommand(new CommandTreeHelp(this));
    }
    @Override
    public String getName() {
        return "oink";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return null;
    }
}
