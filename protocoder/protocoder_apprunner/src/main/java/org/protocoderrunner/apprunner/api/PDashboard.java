/*
 * Protocoder 
 * A prototyping platform for Android devices 
 * 
 * Victor Diaz Barrales victormdb@gmail.com
 *
 * Copyright (C) 2014 Victor Diaz
 * Copyright (C) 2013 Motorola Mobility LLC
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the "Software"),
 * to deal in the Software without restriction, including without limitation
 * the rights to use, copy, modify, merge, publish, distribute, sublicense,
 * and/or sell copies of the Software, and to permit persons to whom the Software
 * is furnished to do so, subject to the following conditions: 
 * 
 * The above copyright notice and this permission notice shall be included in all 
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR 
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN 
 * THE SOFTWARE.
 * 
 */

package org.protocoderrunner.apprunner.api;

import android.app.Activity;

import org.json.JSONException;
import org.json.JSONObject;
import org.protocoderrunner.apidoc.annotation.APIMethod;
import org.protocoderrunner.apidoc.annotation.APIParam;
import org.protocoderrunner.apprunner.PInterface;
import org.protocoderrunner.apprunner.ProtocoderScript;
import org.protocoderrunner.apprunner.api.dashboard.PDashboardBackground;
import org.protocoderrunner.apprunner.api.dashboard.PDashboardButton;
import org.protocoderrunner.apprunner.api.dashboard.PDashboardHTML;
import org.protocoderrunner.apprunner.api.dashboard.PDashboardImage;
import org.protocoderrunner.apprunner.api.dashboard.PDashboardInput;
import org.protocoderrunner.apprunner.api.dashboard.PDashboardPlot;
import org.protocoderrunner.apprunner.api.dashboard.PDashboardSlider;
import org.protocoderrunner.apprunner.api.dashboard.PDashboardText;
import org.protocoderrunner.apprunner.api.dashboard.PDashboardVideoCamera;
import org.protocoderrunner.network.CustomWebsocketServer;

import java.net.UnknownHostException;

public class PDashboard extends PInterface {

	String TAG = "PDashboard";

	public PDashboard(Activity a) {
		super(a);
	}

	@ProtocoderScript
	@APIMethod(description = "add a plot in the dashboad", example = "")
	@APIParam(params = { "name", "x", "y", "w", "h", "minLimit", "maxLimit" })
	public PDashboardPlot addPlot(String name, int x, int y, int w, int h, float minLimit, float maxLimit)
			throws UnknownHostException, JSONException {

		PDashboardPlot pWebAppPlot = new PDashboardPlot(a.get());
		pWebAppPlot.add(name, x, y, w, h, minLimit, maxLimit);

		return pWebAppPlot;
	}

	@ProtocoderScript
	@APIMethod(description = "add a HTML content in the dashboard", example = "")
	@APIParam(params = { "htmlFile", "x", "y" })
	public PDashboardHTML addHtml(String html, int x, int y) throws UnknownHostException, JSONException {

		PDashboardHTML pWebAppHTML = new PDashboardHTML(a.get());
		pWebAppHTML.add(html, x, y);

		return pWebAppHTML;
	}

	@ProtocoderScript
	@APIMethod(description = "add a button in the dashboard", example = "")
	@APIParam(params = { "name", "x", "y", "w", "h", "function()" })
	public PDashboardButton addButton(String name, int x, int y, int w, int h,
			final PDashboardButton.jDashboardAddCB callbackfn) throws UnknownHostException, JSONException {

		PDashboardButton pWebAppButton = new PDashboardButton(a.get());
		pWebAppButton.add(name, x, y, w, h, callbackfn);

		return pWebAppButton;
	}

	@ProtocoderScript
	@APIMethod(description = "add a slider in the dashboard", example = "")
	@APIParam(params = { "name", "x", "y", "w", "h", "min", "max", "function(num)" })
	public PDashboardSlider addSlider(String name, int x, int y, int w, int h, int min, int max,
			final PDashboardSlider.jDashboardSliderAddCB callbackfn) throws UnknownHostException, JSONException {

		PDashboardSlider pWebAppSlider = new PDashboardSlider(a.get());
		pWebAppSlider.add(name, x, y, w, h, min, max, callbackfn);

		return pWebAppSlider;
	}

	@ProtocoderScript
	@APIMethod(description = "add a input box in the dashboard", example = "")
	@APIParam(params = { "name", "x", "y", "w", "h", "function(text)" })
	public PDashboardInput addInput(String name, int x, int y, int w, int h, final PDashboardInput.jDashboardInputCB callbackfn)
			throws UnknownHostException, JSONException {

		PDashboardInput pWebAppInput = new PDashboardInput(a.get());
		pWebAppInput.add(name, x, y, w, h, callbackfn);

		return pWebAppInput;
	}

	@ProtocoderScript
	@APIMethod(description = "add a text in the dashboard", example = "")
	@APIParam(params = { "name", "x", "y", "size", "hexColor" })
	public PDashboardText addText(String name, int x, int y, int width, int height, int size, String color)
			throws UnknownHostException, JSONException {

		PDashboardText pWebAppText = new PDashboardText(a.get());
		pWebAppText.add(name, x, y, width, height, size, color);

		return pWebAppText;
	}

	@ProtocoderScript
	@APIMethod(description = "add an image in the dashboard", example = "")
	@APIParam(params = { "url", "x", "y", "w", "h" })
	public PDashboardImage addImage(String url, int x, int y, int w, int h) throws UnknownHostException, JSONException {

		PDashboardImage pWebAppImage = new PDashboardImage(a.get());
		pWebAppImage.add(url, x, y, w, h);

		return pWebAppImage;
	}

    //TODO is not working yet
	//@ProtocoderScript
	@APIMethod(description = "add a camera preview in the dashboard", example = "")
	@APIParam(params = { "url", "x", "y", "w", "h" })
	public PDashboardVideoCamera addCameraPreview(int x, int y, int w, int h) throws UnknownHostException, JSONException {

		PDashboardVideoCamera pWebAppVideoCamera = new PDashboardVideoCamera(a.get());
		pWebAppVideoCamera.add(x, y, w, h);

		return pWebAppVideoCamera;
	}

	@ProtocoderScript
	@APIMethod(description = "change the background color (HEX format) of the dashboard", example = "")
	@APIParam(params = { "hexColor" })
	public PDashboardBackground setBackgroundColor(String hex) throws JSONException, UnknownHostException {
        PDashboardBackground pDashboardBackground = new PDashboardBackground(a.get());
        pDashboardBackground.updateColor(hex);

        return pDashboardBackground;
	}


	@ProtocoderScript
	@APIMethod(description = "show/hide the dashboard", example = "")
	@APIParam(params = { "boolean" })
	public void show(boolean b) {
		JSONObject msg = new JSONObject();
		try {
			JSONObject values = new JSONObject().put("val", b);
            msg.put("type", "widget").put("action", "showDashboard").put("values", values);
		} catch (JSONException e1) {
			e1.printStackTrace();
		}

		try {
			CustomWebsocketServer.getInstance(a.get()).send(msg);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

	}

}
