package pl.uj.io.cuteanimals.plot.actions;

import java.util.List;
import java.util.Map;
import java.util.Random;
import pl.uj.io.cuteanimals.model.*;
import pl.uj.io.cuteanimals.model.interfaces.*;

public class DungeonEntranceGoAction extends ContainerArgumentAction<ILocation> {
    public DungeonEntranceGoAction(Map<String, ILocation> wheres) {
        super(wheres);
    }

    @Override
    public IResult actionBody(IPlayer player, String toGoName) {
        var toGo = objects.get(toGoName);

        if (toGo == null) {
            return new Result("You want to go... where?");
        }

        Random rand = new Random();
        int result = rand.nextInt(10);
        if (result < 4) {
            toGo = WorldMap.getInstance().getLocation("medical");
        }

        player.changeLocation(toGo);
        return new Result(toGo.getDescription());
    }

    @Override
    public List<GameState> getAcceptableStates() {
        return List.of(GameState.EXPLORATION);
    }
}