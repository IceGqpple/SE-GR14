package frontend_api;

import Service.RuteService;
import Service.StoppeStedService;
import adapter.SqlRuteAdapter;
import adapter.SqlStoppeStedAdapter;
import domain.MockData;
import domain.ReiseSok;
import domain.StoppeSted;
import io.javalin.Javalin;
import io.javalin.http.Context;

/*
For å gjore et reisesøk med reisesok path så formateringen under hvor,
start= er startpunktet på reisen og stopp= er sluttpunktet på reisen.

    "http://localhost:7000/reisesok?start="Sarpsborg"&stopp=Halden"
*/

public class Frontend_Api {
    Javalin app;
    static MockData data = new MockData();
    public Frontend_Api(){
        app = Javalin.create().start(7000);
        app.get("/stoppesteder", Frontend_Api::getStoppeSteder);
        app.get("/reisesok", Frontend_Api::getReiser);
    }

    public static void getStoppeSteder(Context context){
        StoppeStedService stoppeSted = new StoppeStedService(new SqlStoppeStedAdapter());
        context.json(stoppeSted.hentStoppeSted());
    }

    public static void getReiser(Context context) {
        RuteService ruter = new RuteService(new SqlRuteAdapter());
        ReiseSok reiseSok = new ReiseSok(new StoppeSted(context.queryParam("start")),new StoppeSted(context.queryParam("stopp")), ruter.hentRuter());
        context.json(reiseSok.getReiser());
    }

}
