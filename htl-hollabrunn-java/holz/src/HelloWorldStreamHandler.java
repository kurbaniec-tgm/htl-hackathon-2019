import com.amazon.ask.Skill;
import com.amazon.ask.Skills;
import com.amazon.ask.SkillStreamHandler;
import handlers.HelloWorldIntentHandler;
import handlers.LaunchRequestHandler;
import handlers.SessionEndedRequestHandler;
import handlers.CancelandStopIntentHandler;
import handlers.HelpIntentHandler;


public class HelloWorldStreamHandler extends SkillStreamHandler {
    private static final String SKILL_ID = "amzn1.ask.skill.87623646-3fcb-40da-9707-958149a06d8b";

    private static Skill getSkill() {
        return Skills.standard()
                .addRequestHandlers(
                        new CancelandStopIntentHandler(),
                        new HelpIntentHandler(),
                        new LaunchRequestHandler(),
                        new SessionEndedRequestHandler(),
                        new HelloWorldIntentHandler())
                .withSkillId(SKILL_ID)
                .build();
    }

    public HelloWorldStreamHandler() {
        super(getSkill());
    }

}
