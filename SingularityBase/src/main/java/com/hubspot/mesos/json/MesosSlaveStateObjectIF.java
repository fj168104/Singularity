package com.hubspot.mesos.json;

import java.util.List;

import org.immutables.value.Value.Immutable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.hubspot.immutables.style.SingularityStyle;

@Immutable
@SingularityStyle
@JsonDeserialize(as = MesosSlaveStateObject.class)
public interface MesosSlaveStateObjectIF {

  String getId();

  String getPid();

  String getHostname();

  @JsonProperty("start_time")
  long getStartTime();

  MesosResourcesObject getResources();

  List<MesosSlaveFrameworkObject> getFrameworks();

  @JsonProperty("finished_tasks")
  int getFinishedTasks();

  @JsonProperty("lost_tasks")
  int getLostTasks();

  @JsonProperty("started_tasks")
  int getStartedTasks();

  @JsonProperty("failed_tasks")
  int getFailedTasks();

  @JsonProperty("killed_tasks")
  int getKilledTasks();

  @JsonProperty("staged_tasks")
  int getStagedTasks();
}