package org.fundacionjala.pivotal.jbehave;

import java.util.Arrays;
import java.util.List;

import org.jbehave.core.embedder.Embedder;
import org.jbehave.core.junit.JUnitStories;

/**
 * Created by mijhailvillarroel on 8/2/2016.
 */
public class LoginBehaveStory {

//    public class SimpleJBehave {

//        public SimpleJBehave() {
//            super();
//            this.configuredEmbedder().candidateSteps().add(new LoginBehaveSteps());
//        }
//
//        @Override
//        protected List<String> storyPaths() {
//            return Arrays.asList("resources/stories/test.story");
//        }
//    }

        private static Embedder embedder = new Embedder();
        private static List<String> storyPaths = Arrays
                .asList("D:/Selenio/QADEV07Pivotal/src/test/java/org/fundacionjala/pivotal/jbehave/test.story");


        public static void main(String[] args) {
            embedder.candidateSteps().add(new LoginBehaveSteps());
            embedder.runStoriesAsPaths(storyPaths);
        }
}
