package com.myorg;

import software.amazon.awscdk.Stack;
import software.amazon.awscdk.StackProps;
import software.amazon.awscdk.services.ec2.Vpc;
import software.constructs.Construct;

public class AluraVpcStack extends Stack {

    private static final String NOME_VPC = "AluraVpc";

    private Vpc vpc; // Expondo a VPC pra conseguirmos pegá-la.

    public AluraVpcStack(final Construct scope, final String id) {
        this(scope, id, null);
    }

    public AluraVpcStack(final Construct scope, final String id, final StackProps props) {
        super(scope, id, props);

        vpc = Vpc.Builder.create(this, NOME_VPC)
                .maxAzs(3)  // Quantidade máxima de zonas de disponibilidade
                .build();
    }

    public Vpc getVpc() {
        return vpc;
    }
}
