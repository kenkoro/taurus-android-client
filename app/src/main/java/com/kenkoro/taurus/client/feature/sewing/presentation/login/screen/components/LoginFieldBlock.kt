package com.kenkoro.taurus.client.feature.sewing.presentation.login.screen.components

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.kenkoro.taurus.client.R
import com.kenkoro.taurus.client.feature.sewing.domain.model.request.LoginRequest
import com.kenkoro.taurus.client.feature.sewing.presentation.login.screen.LoginViewModel
import com.kenkoro.taurus.client.ui.theme.AppTheme
import kotlinx.coroutines.launch

@Composable
fun LoginFieldBlock(
  onLogin: () -> Unit,
  viewModel: LoginViewModel = hiltViewModel(),
  @SuppressLint("ModifierParameter") modifier: Modifier = Modifier,
) {
  val subject = viewModel.subject
  val password = viewModel.password
  val scope = rememberCoroutineScope()

  Column(
    horizontalAlignment = Alignment.End,
  ) {
    OutlinedTextField(
      value = subject.value,
      onValueChange = { subject.value = it },
      shape = RoundedCornerShape(50),
      placeholder = {
        Text(text = stringResource(id = R.string.login_subject))
      },
      keyboardOptions =
      KeyboardOptions.Default.copy(
        imeAction = ImeAction.Next,
        keyboardType = KeyboardType.Text,
      ),
      modifier =
      Modifier
        .fillMaxWidth(),
    )
    Spacer(modifier = Modifier.height(15.dp))
    OutlinedTextField(
      value = password.value,
      onValueChange = { password.value = it },
      shape = RoundedCornerShape(50),
      placeholder = {
        Text(text = stringResource(id = R.string.login_password))
      },
      visualTransformation = PasswordVisualTransformation(),
      keyboardOptions =
      KeyboardOptions.Default.copy(
        imeAction = ImeAction.Done,
        keyboardType = KeyboardType.Password,
      ),
      keyboardActions =
      KeyboardActions(
        onDone = { onLogin() },
      ),
      modifier =
      Modifier
        .fillMaxWidth(),
    )
    Spacer(modifier = Modifier.height(15.dp))
    Button(
      modifier =
      Modifier
        .size(width = 80.dp, height = 50.dp),
      onClick = {
        scope.launch {
          val response = viewModel.login(
            LoginRequest(
              subject = subject.value,
              password = password.value
            )
          )
          Log.d("Auth", response.token)
        }
      },
    ) {
      Icon(imageVector = Icons.Default.KeyboardArrowRight, contentDescription = "Login button")
    }
  }
}

@Preview(showBackground = true)
@Composable
fun LoginFieldBlockPreview() {
  AppTheme {
    LoginFieldBlock(onLogin = {})
  }
}