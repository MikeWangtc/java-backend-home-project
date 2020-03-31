package com.test.bank.service;

import com.test.bank.initializer.DataSourceInitializer;
import com.test.bank.model.TransferResponse;
import org.jooq.impl.DefaultConfiguration;

import javax.inject.Inject;
import javax.inject.Singleton;

import static com.test.bank.db.Tables.USER;
import org.jooq.impl.DSL;
import org.jooq.DSLContext;
import org.jooq.types.UInteger;
import com.test.bank.model.User;


@Singleton
public class TransactionService {

    DefaultConfiguration jooqConfiguration;

    @Inject
    public TransactionService(DataSourceInitializer dataSourceInitializer) {
        this.jooqConfiguration = dataSourceInitializer.getJooqConfiguration();
    }

    public TransferResponse transfer(int fromUserId, int toUserId, int amount) {
        // TODO implement transfer
        TransferResponse rtn_response = new TransferResponse();
        DSLContext create = DSL.using(jooqConfiguration);
        Integer  fromUsrWallet = create
                                .select(USER.WALLET)
                                .from(USER)
                                .where(USER.ID.eq(UInteger.valueOf(fromUserId)))
                                .fetchAny()
                                .getValue(USER.WALLET);
        Integer toUsrWallet =   create
                                .select(USER.WALLET)
                                .from(USER)
                                .where(USER.ID.eq(UInteger.valueOf(toUserId)))
                                .fetchAny()
                                .getValue(USER.WALLET);

        if (fromUsrWallet >= amount){
            fromUsrWallet -= amount;
            toUsrWallet += amount;

            create.update(USER)
                  .set(USER.WALLET, fromUsrWallet)
                  .where(USER.ID.eq(UInteger.valueOf(fromUserId)))
                  .execute();
            create.update(USER)
                  .set(USER.WALLET, toUsrWallet)
                  .where(USER.ID.eq(UInteger.valueOf(toUserId)))
                  .execute();
            
            User fromUser = new User();
            User toUser = new User();
            fromUser.setId(Integer.valueOf(fromUserId));
            fromUser.setWallet(Integer.valueOf(fromUsrWallet));
            toUser.setId(Integer.valueOf(toUserId));
            toUser.setWallet(Integer.valueOf(toUsrWallet));
            rtn_response.setFromUser(fromUser);
            rtn_response.setToUser(toUser);

            return rtn_response;
        }

        return null;
    }

}
