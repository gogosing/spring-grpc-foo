package me.gogosing.service.impl;

import io.grpc.Channel;
import me.gogosing.sample.proto.MessageRequest;
import me.gogosing.sample.proto.MessageResponse;
import me.gogosing.sample.proto.SampleGrpc;
import me.gogosing.service.MessageService;
import net.devh.boot.grpc.client.channelfactory.GrpcChannelFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * Created by JinBum Jeong on 2020/03/02.
 */
@Service
public class MessageServiceImpl implements MessageService {

    private final GrpcChannelFactory grpcChannelFactory;

    private SampleGrpc.SampleBlockingStub sampleStub;

    public MessageServiceImpl(GrpcChannelFactory grpcChannelFactory) {
        this.grpcChannelFactory = grpcChannelFactory;
    }

    @PostConstruct
    public void init() {
        Channel channel = grpcChannelFactory.createChannel("bar-service-client");
        sampleStub = SampleGrpc.newBlockingStub(channel);
    }

    @Override
    public String getExternalMessage(String salt) {
        MessageRequest request = MessageRequest.newBuilder()
                .setContents(salt)
                .build();

        MessageResponse response = sampleStub.getMessage(request);

        return response.getContents();
    }
}
