package com.myorg;

import software.amazon.awscdk.App;
import software.amazon.awscdk.Environment;
import software.amazon.awscdk.StackProps;

import java.util.Arrays;

public class AluraAwsInfraApp {
    public static void main(final String[] args) {
        App app = new App();

        // Criando a nova VPC:
        AluraVpcStack aluraVpcStack = new AluraVpcStack(app, "Vpc");

        // Criação de novo Cluster:
        AluraClusterStack aluraClusterStack = new AluraClusterStack(app, "Cluster", aluraVpcStack.getVpc());
        aluraClusterStack.addDependency(aluraVpcStack); // Informa que o Cluster tem dependência da VPC, dessa forma a VPC precisa estar criada primeiramente.

        app.synth();
    }
}

