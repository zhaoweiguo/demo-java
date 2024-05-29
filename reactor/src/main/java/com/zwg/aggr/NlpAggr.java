package com.zwg.aggr;

import com.zwg.gateway.NlpEngineGateway;
import lombok.Getter;
import com.zwg.model.NlpDTO;
import reactor.core.publisher.Flux;
import com.zwg.req.NlpRequest;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class NlpAggr {

    @Getter
    private final NlpRequest request;
    private final List<Flux<NlpDTO>> results = new LinkedList<>();

    public NlpAggr(NlpRequest request) {
        this.request = request;
    }

    public Flux<NlpDTO> getResult() {
        // Flux.concatDelayError 是 Reactor 提供的一个用于合并多个 Flux 序列的操作符。它会按顺序逐个订阅并合并多个 Flux 序列，并在其中一个 Flux 序列发生错误时，延迟报告错误，直到所有序列完成或者全部发生错误后再报告错误。
        // Flux.fromIterable 是 Reactor 提供的一个静态工厂方法，用于创建一个包含指定 Iterable 中元素的 Flux 序列。它接受一个 Iterable 对象作为参数，并将该 Iterable 中的元素逐个发出到 Flux 序列中。
        // Flux.concatWithValues 是 Reactor 提供的一个操作符，用于将指定的值与当前 Flux 序列的元素合并，形成一个新的 Flux 序列。
        return Flux.concatDelayError(Flux.fromIterable(results))
                .concatWithValues(new NlpDTO()
                        .setFocus("chat"));
    }


    public NlpAggr processOn(List<NlpEngineGateway> nlpEngineGateways) {
        // 把nlpEngineGateways 转换成map，并去除重复(有重复的选前面的): key(a, b) -> a
        Map<String, NlpEngineGateway> gateways = nlpEngineGateways.stream()
                .collect(Collectors.toMap(g->g.getEngineType().getValue(), g -> g, (a, b) -> a));
        NlpAggr aggr = this;
        return aggr;
    }

}
