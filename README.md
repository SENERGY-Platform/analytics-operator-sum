# analytics-operator-sum

VAR | Default | Desc
------------- | ------------- | -------------
CONFIG_APPLICATION_ID  | stream-operator | Application ID
CONFIG_BOOTSTRAP_SERVERS  | queried from zookeeper | List of kafka brokers, optional if ZK_Quorum is given
ZK_QUORUM  | localhost:2181 | zookeeper instances
KAFKA_TOPIC  | input-stream | inputstream name
KAFKA_OUTPUT  | output-stream | outputstream name
INPUT_VALUE  | value | value to be added
OUTPUT_SUM  | sum | sum