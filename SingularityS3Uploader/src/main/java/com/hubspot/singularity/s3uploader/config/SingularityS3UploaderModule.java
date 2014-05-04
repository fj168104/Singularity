package com.hubspot.singularity.s3uploader.config;

import com.google.inject.AbstractModule;
import com.hubspot.singularity.runner.base.config.SingularityRunnerBaseModule;
import com.hubspot.singularity.runner.base.shared.SingularityDriver;
import com.hubspot.singularity.s3uploader.SingularityS3UploaderDriver;

public class SingularityS3UploaderModule extends AbstractModule {
  
  @Override
  protected void configure() {
    install(new SingularityRunnerBaseModule("/etc/singularity.s3uploader.properties", new SingularityS3UploaderConfigurationLoader()));
    bind(SingularityDriver.class).to(SingularityS3UploaderDriver.class);
  }

}
