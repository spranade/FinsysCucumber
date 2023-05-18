package com.springkafkatest.service;
import java.util.Properties;
import java.util.concurrent.Future;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

public class Producer {

            public static void produce(String Kafkamsg , String KafkaTopic){
                Properties properties = new Properties();
//              properties.put("bootstrap.servers", "kafka-tst-0.europe.intranet:9092 , kafka-tst-1.europe.intranet:9092");
                properties.put("bootstrap.servers", "localhost:9092");
                properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
                properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

                KafkaProducer kafkaProducer = new KafkaProducer(properties);
                 try{
                         String KafkaMessage = Kafkamsg;
                         System.out.println(Kafkamsg);
                         Future<RecordMetadata> ack = kafkaProducer.send(new ProducerRecord(KafkaTopic, KafkaMessage ));
                         RecordMetadata metadata = ack.get();
                         System.out.println(metadata.offset()+ " " + metadata.partition());
                         Thread.sleep(1000);
                    }

                catch (Exception e){
                    e.printStackTrace();
                }finally {
                    kafkaProducer.close();
                }
            }




    public static void main(String[] args){

        Properties properties = new Properties();
        properties.put("bootstrap.servers", "localhost:9092");
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        KafkaProducer kafkaProducer = new KafkaProducer(properties);
        try{
            for(int i = 0; i < 5; i++){
            	String KafkaMessage = "{\"jsonabc\"}";
                System.out.println(i);
                System.out.println(KafkaMessage);
                Future<RecordMetadata> ack = kafkaProducer.send(new ProducerRecord("KAFKATEST", KafkaMessage ));
                //kafkaProducer.send(new ProducerRecord("KAFKATEST", Integer.toString(i), "test message - " + i ));
                RecordMetadata metadata = ack.get();
                System.out.println(metadata.offset()+ " " + metadata.partition());
            }
        }

        catch (Exception e){
            e.printStackTrace();
        }finally {
            kafkaProducer.close();
        }
    }
}