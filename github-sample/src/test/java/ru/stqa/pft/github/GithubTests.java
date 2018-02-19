package ru.stqa.pft.github;

import com.google.common.collect.ImmutableMap;
import com.jcabi.github.*;
import org.testng.annotations.Test;

import java.io.IOException;

public class GithubTests {

  @Test
  public void testCommits() throws IOException {
    Github github = new RtGithub("7d0681699126d9dc2232bb7fef3adb29f2ea8701");
    RepoCommits commits = github.repos().get(new Coordinates.Simple("liiatana", "java_Edu")).commits();
    for(RepoCommit commit:commits.iterate(new ImmutableMap.Builder<String, String>().build())) {
      System.out.println(commit);
      System.out.println(new RepoCommit.Smart(commit).message()  );
    }

  }
}
