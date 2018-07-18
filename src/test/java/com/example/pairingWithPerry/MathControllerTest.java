package com.example.pairingWithPerry;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(MathController.class)
public class MathControllerTest {

    @Autowired
    private MockMvc mvc;

    //Note naming convention when_given_then
    @Test
    public void volume_withAllZeroes_returnZero() throws Exception {
        // given
        int x = 0, y = 0, z = 0;
        String url = "/" + x + "/" + y + "/" + z;
        int sum = x * y * z;

        // when
        this.mvc.perform(get(url).accept(MediaType.TEXT_PLAIN))

         //then
            .andExpect(status().isOk())
            .andExpect(content().string(String.valueOf(sum)));
    }

    //Note naming convention when_given_then
    @Test
    public void volume_withNonZeroValues_returnSum() throws Exception {
        // given

        // when
        ResultActions result = callVolume(1, 2, 3);

        //then
        result
            .andExpect(status().isOk())
            .andExpect(content().string("6"));
    }

    private ResultActions callVolume(int x, int y, int z) throws Exception {
        String url = "/" + x + "/" + y + "/" + z;
        return this.mvc.perform(get(url).accept(MediaType.TEXT_PLAIN));
    }

}
