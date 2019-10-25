package me.tacticaldev.proudnetworkbosses;

import me.tacticaldev.proudnetworkbosses.managers.UserManager;
import me.tacticaldev.proudnetworkbosses.utils.Text;
import me.tacticaldev.proudnetworkbosses.utils.User;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;

public class Board {

    //    private static TeamManager teamManager = Survival.getInstance().getTeamManager();
    private static UserManager userManager = ProudBosses.getInstance().getUserManager();

    public static void showScoreboard(Player p) {
        if (p.getScoreboard().equals(p.getServer().getScoreboardManager().getMainScoreboard())) {
            p.setScoreboard(p.getServer().getScoreboardManager().getNewScoreboard());
        }

        User user = userManager.getUserByPlayer(p);

        ScoreboardManager scoreboardManager = Bukkit.getScoreboardManager();
        Scoreboard scoreboard = scoreboardManager.getNewScoreboard();
        Objective objective = scoreboard.registerNewObjective("bleadnight", "dummy");

        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        objective.setDisplayName(Text.color("&6&lBleadNight"));

        Score leeg = objective.getScore(" ");
        leeg.setScore(20);
        Score leeg2 = objective.getScore("   ");
        leeg2.setScore(19);
        Score spelerScore = objective.getScore(Text.color("&2Speler &7»"));
        spelerScore.setScore(18);
        Score leeg3 = objective.getScore("    ");
        leeg3.setScore(17);
        Score spelerCoins = objective.getScore(Text.color("&aCoins&f: &7" + user.getCoins()));
        spelerCoins.setScore(16);
        Score leeg5 = objective.getScore("     ");
        leeg5.setScore(15);
        Score ip = objective.getScore(Text.color("&7play.CloudMc.nl"));
        ip.setScore(14);

        p.setScoreboard(scoreboard);
    }
}
