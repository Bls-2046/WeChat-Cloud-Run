package com.github.wechatcloudrun.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Objects;

@Data
public class ScheduleRequest {

    private static final String REQUEST_KEY = "TJh84V4E!xp0]xExSI$<Tiy7YO&]0Xa{NG:]%wk4Vb]f62Xd*ivmrI)|3Q<#.)YHfXn7/l]Uvpn/H;)R9+[LiXk*=>oB*N2M$2EebSU3Uf(Mg1=i=-5A9$<k.jb'7rm>w/_UeJ3/0Ri,bdxOo{diKJST9DO8o-r{!u[:&*q10>a.Fq>LM{qETHkPy?lSDzpWqv2YC9OpL'PQ7pW%/+(IY2041CP\"c,P#H(F*a'GToEWF1[Hqbp;EqdVI$Ri5yH<cvv8$<JR?hve6bSp6Wdg,;H?@exz]ESxZ0&{$>y_(Z;}1*hD,a[iYFCnO?DX2[rV4I?;tc1.-Mg:6+{CXaUoS+w2zm{e}(wmA&APv$3]\"T7)S=>aaun[dT'>*_glJ6W{bMSR0RLigrO>0o@{CO0/s%]F%t;Ljk?E<X<J>;G)b_[BYd9:KD:lddg($Gsi7<K=Mhyi!(hNzs%*-1z?G7C;_b&@:}yEpn>R#cIXkvz6Jlo?h=6.mQK?dm:m2;)zw!|Xp]I\"fDh%ZH4O|Mp:D%OA?ar?{Q%U:5[oX#=+Icq?6!1J[sqU!o&0hk(HRZK=]q!wrV{79dr*LI.HI2z-fjx=i|D|+6o@p?>({Z50<7TMlv-4Pu'UrpJH!r48Z\"D9*y+H>$X'60h5t1!?l./OEt0#jAbf5?fd?bcITh<i35#/2j}Ku)L'A{,CTR{($,|e_9]6w[,0'5mwNZWfiIV6fhQkr]\"udY,N+MW)V!zFR/8bp7*mg<2(Nm7AwpDgqUuVKMnp'U#-VncRgwo3%Pd6>|*K[aF[.s$+)9'<)5c9,4RBF9*5(J1w$MlK)G?//Ym[7q0_O$*F{|uEHEd%&L-mi!T)yFJt7eo%lro[v32f)HJuHi6+.AE\"|Dv|O[{!&O|,:Mt]hP-So3z[+FxoH5Scz)]@)V#+DQwvh?)}Sm5)cR6og@=3hg5<$cCh,9=I&IeTIRq7D.e2Gk?&?.ptm'STgtkL{p'PsR1E<:33.)[H=yiAn";

    private String requestKey;
    private String username;
    private ReminderMessage reminderMessage;

    // 请求密钥, 验证是否为指定服务器
    public static Boolean verifyRequest(String requestKey) {
        return Objects.equals(requestKey, REQUEST_KEY);
    }

    @Data
    public static class ReminderMessage {
        private String userID;
        private String eventTitle;
        private LocalDateTime eventDateTime;
        private String eventDescription;
    }
}
