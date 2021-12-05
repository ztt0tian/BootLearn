package com.ztt.api.config;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.interceptor.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Aspect
@Configuration
public class GlobalTransactionConfig {
    public static final int AOP_TIME_OUT = 50000;
    public static final String AOP_POINTCUT_EXPRESSION = "execution(* com.ztt.api.service..*.*(..))";
    private final PlatformTransactionManager platformTransactionManager;

    public GlobalTransactionConfig(PlatformTransactionManager platformTransactionManager) {
        this.platformTransactionManager = platformTransactionManager;
    }

    @Bean
    public TransactionInterceptor txAdvice() {
        NameMatchTransactionAttributeSource source = new NameMatchTransactionAttributeSource();
        RuleBasedTransactionAttribute readOnlyTx = new RuleBasedTransactionAttribute();
        readOnlyTx.setReadOnly(true);
        readOnlyTx.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        RuleBasedTransactionAttribute requireTx = new RuleBasedTransactionAttribute();
        requireTx.setReadOnly(false);
        requireTx.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        requireTx.setTimeout(AOP_TIME_OUT);
        requireTx.setRollbackRules(Collections.singletonList(new RollbackRuleAttribute(Exception.class)));
        Map<String, TransactionAttribute> nameMap = new HashMap<String, TransactionAttribute>(){{
            put("save*",requireTx);
            put("add*",requireTx);
            put("update*",requireTx);
            put("modify*",requireTx);
            put("del*",requireTx);
            put("register*",requireTx);
            put("do*", requireTx);
            put("query*", requireTx);
        }};
        source.setNameMap(nameMap);
        return new TransactionInterceptor(platformTransactionManager, source);
    }

    @Bean
    public Advisor txAdvisor() {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression(AOP_POINTCUT_EXPRESSION);
        return new DefaultPointcutAdvisor(pointcut, txAdvice());
    }
}
