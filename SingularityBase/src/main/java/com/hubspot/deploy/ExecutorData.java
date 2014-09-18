package com.hubspot.deploy;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Objects;
import com.google.common.base.Optional;
import com.hubspot.mesos.JavaUtils;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ExecutorData {

  private final String cmd;
  private final List<EmbeddedArtifact> embeddedArtifacts;
  private final List<ExternalArtifact> externalArtifacts;
  private final List<S3Artifact> s3Artifacts;
  private final List<Integer> successfulExitCodes;
  private final Optional<String> runningSentinel;
  private final Optional<String> user;
  private final List<String> extraCmdLineArgs;
  private final Optional<String> loggingTag;
  private final Map<String, String> loggingExtraFields;
  private final Optional<Long> sigKillProcessesAfterMillis;

  @JsonCreator
  public ExecutorData(@JsonProperty("cmd") String cmd, @JsonProperty("embeddedArtifacts") List<EmbeddedArtifact> embeddedArtifacts, @JsonProperty("externalArtifacts") List<ExternalArtifact> externalArtifacts,
      @JsonProperty("s3Artifacts") List<S3Artifact> s3Artifacts, @JsonProperty("successfulExitCodes") List<Integer> successfulExitCodes, @JsonProperty("user") Optional<String> user,
      @JsonProperty("runningSentinel") Optional<String> runningSentinel, @JsonProperty("extraCmdLineArgs") List<String> extraCmdLineArgs, @JsonProperty("loggingTag") Optional<String> loggingTag,
      @JsonProperty("loggingExtraFields") Map<String, String> loggingExtraFields, @JsonProperty("sigKillProcessesAfterMillis") Optional<Long> sigKillProcessesAfterMillis) {
    this.cmd = cmd;
    this.embeddedArtifacts = JavaUtils.nonNullImmutable(embeddedArtifacts);
    this.externalArtifacts = JavaUtils.nonNullImmutable(externalArtifacts);
    this.s3Artifacts = JavaUtils.nonNullImmutable(s3Artifacts);
    this.user = user;
    this.successfulExitCodes = JavaUtils.nonNullImmutable(successfulExitCodes);
    this.extraCmdLineArgs = JavaUtils.nonNullImmutable(extraCmdLineArgs);
    this.runningSentinel = runningSentinel;
    this.loggingTag = loggingTag;
    this.loggingExtraFields = JavaUtils.nonNullImmutable(loggingExtraFields);
    this.sigKillProcessesAfterMillis = sigKillProcessesAfterMillis;
  }

  public ExecutorDataBuilder toBuilder() {
    return new ExecutorDataBuilder(cmd, embeddedArtifacts, externalArtifacts, s3Artifacts, successfulExitCodes, runningSentinel, user, extraCmdLineArgs, loggingTag, loggingExtraFields, sigKillProcessesAfterMillis);
  }

  public String getCmd() {
    return cmd;
  }

  public Optional<String> getLoggingTag() {
    return loggingTag;
  }

  public Map<String, String> getLoggingExtraFields() {
    return loggingExtraFields;
  }

  public List<EmbeddedArtifact> getEmbeddedArtifacts() {
    return embeddedArtifacts;
  }

  public List<ExternalArtifact> getExternalArtifacts() {
    return externalArtifacts;
  }

  public List<Integer> getSuccessfulExitCodes() {
    return successfulExitCodes;
  }

  public List<String> getExtraCmdLineArgs() {
    return extraCmdLineArgs;
  }

  public Optional<String> getRunningSentinel() {
    return runningSentinel;
  }

  public Optional<String> getUser() {
    return user;
  }

  public Optional<Long> getSigKillProcessesAfterMillis() {
    return sigKillProcessesAfterMillis;
  }

  public List<S3Artifact> getS3Artifacts() {
    return s3Artifacts;
  }

  @Override
  public String toString() {
    return Objects.toStringHelper(this)
        .add("cmd", cmd)
        .add("embeddedArtifacts", embeddedArtifacts)
        .add("externalArtifacts", externalArtifacts)
        .add("s3Artifacts", s3Artifacts)
        .add("user", user)
        .add("successfulExitCodes", successfulExitCodes)
        .add("runningSentinel", runningSentinel)
        .add("extraCmdLineArgs", extraCmdLineArgs)
        .add("loggingTag", loggingTag)
        .add("loggingExtraFields", loggingExtraFields)
        .add("sigKillProcessesAfterMillis", sigKillProcessesAfterMillis)
        .toString();
  }
}
