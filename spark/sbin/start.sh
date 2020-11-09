
function findFileStr(){
  findDir=$1
  patternFindStr=$2
  separatorChar=$3
  xmlArr=($(find ${findDir} -name "${patternFindStr}"))
  xmlArrLen=${#xmlArr[@]}

  confStr="";
  for((i=0;i<${xmlArrLen};i++))
  do
    if [ ${i} -gt 0 ];then
      confStr=${confStr}""${separatorChar}
    fi
    confStr=${confStr}""${xmlArr[i]}
  done
  echo ${confStr}
}

dependencyFileStr=$(findFileStr "lib" "*.jar" ",")

spark-submit \
--class com.learn.hadoop.spark.SparkApplication \
--driver-java-options "-DjavaOptionFlag=open -DjavaOptionArg=arg1" \
--master yarn \
--deploy-mode client \
--executor-memory 100m \
--num-executors 2 \
--executor-cores 1 \
--executor-memory 512m \
--jars "${dependencyFileStr}" \
jars/spark-0.0.1-SNAPSHOT.jar   > out.log 2>&1
