package org.lightadmin.core.config.bootstrap.parsing.validation;

import org.lightadmin.core.config.LightAdminConfiguration;
import org.lightadmin.core.config.bootstrap.parsing.DomainConfigurationProblem;
import org.lightadmin.core.config.bootstrap.parsing.InvalidPropertyConfigurationProblem;
import org.lightadmin.core.config.bootstrap.parsing.configuration.DomainConfigurationUnitType;
import org.lightadmin.core.config.domain.unit.ConfigurationUnits;
import org.springframework.core.io.ResourceLoader;
import org.springframework.data.mapping.context.MappingContext;

public class DomainConfigurationValidationContext {

    private final LightAdminConfiguration lightAdminConfiguration;

    private final ConfigurationUnits configurationUnits;
    private final DomainConfigurationUnitType configurationUnitType;

    private final MappingContext mappingContext;
    private final ResourceLoader resourceLoader;

    public DomainConfigurationValidationContext(LightAdminConfiguration lightAdminConfiguration, ConfigurationUnits configurationUnits, DomainConfigurationUnitType configurationUnitType, MappingContext mappingContext, ResourceLoader resourceLoader) {
        this.lightAdminConfiguration = lightAdminConfiguration;
        this.configurationUnits = configurationUnits;
        this.configurationUnitType = configurationUnitType;
        this.mappingContext = mappingContext;
        this.resourceLoader = resourceLoader;
    }

    public DomainConfigurationProblem createDomainConfigurationProblem(String message) {
        return new DomainConfigurationProblem(configurationUnits, message);
    }

    public DomainConfigurationProblem createDomainUnitConfigurationProblem(String message) {
        return new DomainConfigurationProblem(configurationUnits, configurationUnitType, message);
    }

    public InvalidPropertyConfigurationProblem notPersistableFieldProblem(String propertyName) {
        return InvalidPropertyConfigurationProblem.missingFieldProblem(configurationUnits, configurationUnitType, propertyName);
    }

    public InvalidPropertyConfigurationProblem rendererNotDefinedForFieldProblem(String propertyName) {
        return InvalidPropertyConfigurationProblem.rendererNotDefinedForFieldProblem(configurationUnits, configurationUnitType, propertyName);
    }

    public InvalidPropertyConfigurationProblem notSupportedTypeFieldProblem(String propertyName) {
        return InvalidPropertyConfigurationProblem.notSupportedTypeFieldProblem(configurationUnits, configurationUnitType, propertyName);
    }

    public InvalidPropertyConfigurationProblem missingBaseDirectoryInFileReferenceProblem(String propertyName) {
        return InvalidPropertyConfigurationProblem.missingBaseDirectoryInFileReferenceProblem(configurationUnits, configurationUnitType, propertyName);
    }

    public InvalidPropertyConfigurationProblem invalidPropertyValueExpressionProblem(String propertyName) {
        return InvalidPropertyConfigurationProblem.invalidPropertyValueExpressionProblem(configurationUnits, configurationUnitType, propertyName);
    }


    public LightAdminConfiguration getLightAdminConfiguration() {
        return lightAdminConfiguration;
    }

    public MappingContext getMappingContext() {
        return mappingContext;
    }

    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }

    public ConfigurationUnits getConfigurationUnits() {
        return configurationUnits;
    }

    public DomainConfigurationUnitType getConfigurationUnitType() {
        return configurationUnitType;
    }
}